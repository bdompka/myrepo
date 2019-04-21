package com.online.om.inventory.dataaccess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = OrderEntity.ORDER_TABLE)
@EqualsAndHashCode()
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter()
@Setter()
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ORDER_TABLE = "INV_ORDER";

	public static final String ID_COLUMN = "ORD_ID";

	public static final String PRODUCT_ID_COLUMN = "ORD_PRODUCT_ID";

	public static final String ORDER_ID_COLUMN = "ORD_ORDER_ID";

	public static final String PRODUCT_NAME_COLUMN = "PRD_NAME";

	public static final String PRODUCT_PRICE_COLUMN = "PRD_PRICE";

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID_COLUMN)
	private long id;

	@Column(name = ORDER_ID_COLUMN)
	private String orderId;

	@Column(name = PRODUCT_ID_COLUMN)
	private String productId;

	@Column(name = PRODUCT_NAME_COLUMN)
	private String productName;

	@Column(name = PRODUCT_PRICE_COLUMN)
	private long productPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getOrderTable() {
		return ORDER_TABLE;
	}

	public static String getIdColumn() {
		return ID_COLUMN;
	}

	public static String getProductIdColumn() {
		return PRODUCT_ID_COLUMN;
	}

	public static String getOrderIdColumn() {
		return ORDER_ID_COLUMN;
	}

	public static String getProductNameColumn() {
		return PRODUCT_NAME_COLUMN;
	}

	public static String getProductPriceColumn() {
		return PRODUCT_PRICE_COLUMN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + (int) (productPrice ^ (productPrice >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderEntity other = (OrderEntity) obj;
		if (id != other.id)
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice != other.productPrice)
			return false;
		return true;
	}
	
	

}
