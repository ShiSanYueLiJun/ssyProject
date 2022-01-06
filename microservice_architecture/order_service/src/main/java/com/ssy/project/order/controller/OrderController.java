package com.ssy.project.order.controller;

import com.ssy.project.order.model.Orders;
import com.ssy.project.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJun
 * @date 2022-01-06 16:43
 */
@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    OrdersService ordersService;

    @RequestMapping("/test")
    public Orders test(){
        Orders byId = ordersService.getById(1L);
        return byId;
    }
}
