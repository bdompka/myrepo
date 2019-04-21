package com.online.om.inventory.api;

import java.util.List;

import com.online.om.inventory.model.OrderBo;
import com.online.om.inventory.model.ProductBo;

public interface InventoryApi {
	List<ProductBo> saveProducts(List<ProductBo> productBos);

	List<OrderBo> saveOrders(List<OrderBo> orderBos);
}
