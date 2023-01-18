package com.giveandtake.userService.controllers;


import com.giveandtake.userService.proxies.OrderProxy;
import com.giveandtake.userService.proxies.beans.OrderBean;
import com.giveandtake.userService.proxies.beans.OrderStatus;
import com.giveandtake.userService.proxies.commandBeans.OrderCommandBean;
import com.giveandtake.userService.proxies.commandBeans.OrderStatusCommandBean;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.giveandtake.userService.constants.PageConstant.PAGE_NB;
import static com.giveandtake.userService.constants.PageConstant.PAGE_SIZE;
import static com.giveandtake.userService.constants.PathConstant.ORDER;
import static com.giveandtake.userService.constants.PathConstant.V1;
import static com.giveandtake.userService.proxies.constants.PathConstant.API;

@RestController
@RequiredArgsConstructor
@RequestMapping(V1+ORDER)
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    private final OrderProxy orderProxy;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderBean addOrder(@RequestBody OrderCommandBean orderCommand){
        return orderProxy.addOrder(orderCommand);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<OrderBean> getOrders(@RequestParam(defaultValue = PAGE_NB) int pageNb, @RequestParam(defaultValue = PAGE_SIZE) int pageSize){
        return orderProxy.getOrders(pageNb,pageSize);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public OrderBean getOrder(@PathVariable String id){
        return orderProxy.getOrder(id);
    }


    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public Page<OrderBean> filterOrders(@RequestParam(defaultValue = PAGE_NB) int pageNb, @RequestParam(defaultValue = PAGE_SIZE) int pageSize,
                                        @RequestParam(required = false) OrderStatus status, @RequestParam(required = false) String orderDate){
        return orderProxy.filterOrders(pageNb,pageSize,status,orderDate);
    }


//    @PostMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public OrderBean updateOrder(@PathVariable String id, @RequestBody OrderCommandBean orderCommand){
//        return orderProxy.(id, orderCommand));
//    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderBean changeOrderStatus(@PathVariable String id, @RequestBody OrderStatusCommandBean statusCommand){
        return orderProxy.changeOrderStatus(id, statusCommand);
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteOrder(@PathVariable String id){
//        orderService.deleteOrder(id);
//    }



}
