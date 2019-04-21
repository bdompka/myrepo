package com.online.om.inventory.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode()
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor()
@Getter()
@Setter()
public class InvoiceBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String invoiceId;
    
    private String productId;

    private String productName;

    private long productPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
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
    
    

}
