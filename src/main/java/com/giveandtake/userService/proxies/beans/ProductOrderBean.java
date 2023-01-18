package com.giveandtake.userService.proxies.beans;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderBean {

    private ProductBean product;
    private int productQuantity;
}
