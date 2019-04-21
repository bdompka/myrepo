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
@Table(name = ProductEntity.PRODUCT_TABLE)
@EqualsAndHashCode()
@Builder
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Getter()
@Setter()
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String PRODUCT_TABLE = "INV_PRODUCT";

	public static final String ID_COLUMN = "PRD_ID";

	public static final String PRODUCT_ACTUAL_ID_COLUMN = "PRD_ACTUAL_ID";

	public static final String PRODUCT_NAME_COLUMN = "PRD_NAME";

	public static final String PRODUCT_PRICE_COLUMN = "PRD_PRICE";

	@Column(name = PRODUCT_ACTUAL_ID_COLUMN)
	private int productId;

	@Column(name = PRODUCT_NAME_COLUMN)
	private String productName;

	@Column(name = PRODUCT_PRICE_COLUMN)
	private long productPrice;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID_COLUMN)
	private long id;

}
