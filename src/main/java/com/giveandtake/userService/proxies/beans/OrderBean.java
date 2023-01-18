package com.giveandtake.userService.proxies.beans;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderBean {

    private String id;
    private String orderDate;
    private OrderStatus status;
    private List<ProductOrderBean> productOrders;
}
