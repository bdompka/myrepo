package com.online.om.inventory.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.om.inventory.api.InventoryApi;
import com.online.om.inventory.model.OrderBo;
import com.online.om.inventory.model.ProductBo;

@RequestMapping("/inventory/v1")
@RestController
public class InventoryRestController {

	@Autowired
	InventoryApi inventoryApi;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductBo> saveProduct(@RequestBody List<ProductBo> productBos) {
		return inventoryApi.saveProducts(productBos);
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	public List<OrderBo> saveOrder(@RequestBody List<OrderBo> orderBos) {
		return inventoryApi.saveOrders(orderBos);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/activationtimespans")
	@ResponseBody
	public void getActivationTimeSpanByFinAndServiceIdAndUserIdAndContext(
			@RequestParam(value = "fin", required = false) String fin,
			@RequestParam(value = "context", required = false) String context,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "serviceId", required = false) Long serviceId) {
	}

}
