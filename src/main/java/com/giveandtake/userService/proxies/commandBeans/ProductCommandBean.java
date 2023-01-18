package com.giveandtake.userService.proxies.commandBeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCommandBean {

    private String name;
    private long price;
    private ProductTypeCommandBean type;
    private String description;
    private int quantity;

}
