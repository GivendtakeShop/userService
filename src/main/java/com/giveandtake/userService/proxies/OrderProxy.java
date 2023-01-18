package com.giveandtake.userService.proxies;

import com.giveandtake.userService.proxies.beans.OrderBean;
import com.giveandtake.userService.proxies.beans.OrderStatus;
import com.giveandtake.userService.proxies.beans.ProductBean;
import com.giveandtake.userService.proxies.commandBeans.OrderCommandBean;
import com.giveandtake.userService.proxies.commandBeans.OrderStatusCommandBean;
import com.giveandtake.userService.proxies.commandBeans.ProductCommandBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.giveandtake.userService.constants.PageConstant.PAGE_NB;
import static com.giveandtake.userService.constants.PageConstant.PAGE_SIZE;
import static com.giveandtake.userService.constants.PathConstant.*;
import static com.giveandtake.userService.proxies.constants.PathConstant.API;


@FeignClient(name = "orderService", url = "localhost:8080" + V1+ORDER)
public interface OrderProxy {

    @PostMapping
    public OrderBean addOrder(@RequestBody OrderCommandBean orderCommand);

    @GetMapping
    public Page<OrderBean> getOrders(@RequestParam(defaultValue = PAGE_NB) int pageNb, @RequestParam(defaultValue = PAGE_SIZE) int pageSize);

    @GetMapping("/{id}")
    public OrderBean getOrder(@PathVariable String id);

    @GetMapping("/filter")
    public Page<OrderBean> filterOrders(@RequestParam(defaultValue = PAGE_NB) int pageNb, @RequestParam(defaultValue = PAGE_SIZE) int pageSize,
                                        @RequestParam(required = false) OrderStatus status, @RequestParam(required = false) String orderDate);

//    @PostMapping("/{id}")
//    public OrderBean updateOrder(@PathVariable String id, @RequestBody OrderCommandBean orderCommand);

    @PutMapping("/{id}")
    public OrderBean changeOrderStatus(@PathVariable String id, @RequestBody OrderStatusCommandBean statusCommand);




}

