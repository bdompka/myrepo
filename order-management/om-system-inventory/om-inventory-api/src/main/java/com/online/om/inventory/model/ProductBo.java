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
public class ProductBo implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String productId;

    private String productName;

    private long productPrice;

}
