package com.ssy.project.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.model.Orders;
import com.ssy.project.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiJun
 * @date 2022-01-06 16:43
 */
@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    OrdersService ordersService;

    @GetMapping("/test/{id}")
    public Orders test(@PathVariable(name = "id") Long id){
        Orders byId = ordersService.getById(id);
        return byId;
    }

    /**
     * 下单
     * @param jsonObject
     * @return
     */
    @PostMapping("/placeAnOrder")
    public String placeAnOrder(@RequestBody JSONObject jsonObject){
        Boolean result = ordersService.placeAnOrder(jsonObject);
        if(result){
            return "下单成功";
        }
        return "下单失败";
    }
}
