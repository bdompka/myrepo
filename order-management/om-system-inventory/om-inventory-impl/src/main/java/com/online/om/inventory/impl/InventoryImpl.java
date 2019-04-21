package com.online.om.inventory.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.stereotype.Component;

import com.online.om.inventory.api.InventoryApi;
import com.online.om.inventory.dataaccess.OrderEntity;
import com.online.om.inventory.dataaccess.OrderRepository;
import com.online.om.inventory.dataaccess.ProductEntity;
import com.online.om.inventory.dataaccess.ProductRepository;
import com.online.om.inventory.impl.mapper.OrderMapper;
import com.online.om.inventory.impl.mapper.ProductMapper;
import com.online.om.inventory.model.InvoiceBo;
import com.online.om.inventory.model.OrderBo;
import com.online.om.inventory.model.ProductBo;
import com.online.om.inventory.queue.ShippingQueueAdapter;

@Component
public class InventoryImpl implements InventoryApi {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	ShippingQueueAdapter shippingQueueAdapter;

	@Override
	public List<ProductBo> saveProducts(List<ProductBo> productBos) {
		return productMapper.mapProductEntitysToProductBos(
				productRepository.save(productMapper.mapProductBosToProductEntitys(productBos)));

	}

	@Override
	public List<OrderBo> saveOrders(List<OrderBo> orderBos) {
		List<String> productIds = new ArrayList<String>();
		for (OrderBo orderBo : orderBos) {
			productIds.add(orderBo.getProductId());
		}

		List<ProductEntity> productEntitys = productRepository.findByProductIdIn(productIds);
		List<OrderEntity> orderEntityResult = new ArrayList<OrderEntity>();
		if (orderBos.size() <= productEntitys.size()) {
			orderEntityResult = orderRepository.save(orderMapper.mapOrderBosToOrderEntitys(orderBos));
		}
		try {
			generateInvoice(orderEntityResult);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return orderMapper.mapOrderEntitysToOrderBos(orderEntityResult);

	}

	private void generateInvoice(List<OrderEntity> orderEntityResult) throws JMSException {
		InvoiceBo invoiceBo = new InvoiceBo();
		invoiceBo.setInvoiceId(UUID.randomUUID().toString());
		for (OrderEntity orderEntity : orderEntityResult) {
			invoiceBo.setProductId(orderEntity.getProductId());
			invoiceBo.setProductName(orderEntity.getProductName());
		}
		postInvoiceToShippingServiceThroughtQueue(invoiceBo);

	}

	private void postInvoiceToShippingServiceThroughtQueue(InvoiceBo invoiceBo) throws JMSException {
		String queuePayload = this.prepareEDISPayload(invoiceBo);
		try {
			this.shippingQueueAdapter.sendInvoiceToShipping(queuePayload);
		} catch (JmsException e) {
			e.printStackTrace();
		}
	}

	private String prepareEDISPayload(InvoiceBo invoiceBo) {

		String headerContent = "Sender" + "Inventory" + "reciever" + "shipping" + "Invoice generate Date "
				+ LocalDate.now();

		StringBuilder queueContentBuilder = new StringBuilder();
		queueContentBuilder.append(headerContent);
		queueContentBuilder.append(System.lineSeparator());
		queueContentBuilder.append(invoiceBo);
		return queueContentBuilder.toString();
	}
}
