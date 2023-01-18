package com.giveandtake.userService.proxies.commandBeans;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class ProductOrderCommandBean {

    private final String productId;
    private final int productQuantity;

}
