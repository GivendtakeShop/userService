package com.giveandtake.userService.proxies.commandBeans;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderCommandBean {

    private List<ProductOrderCommandBean> productOrders;


}