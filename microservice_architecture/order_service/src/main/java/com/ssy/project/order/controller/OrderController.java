package com.ssy.project.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.model.Orders;
import com.ssy.project.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public Orders test(@PathVariable(name = "id") Long id, HttpServletRequest request){
//        int a=10/0;
        Orders byId = ordersService.getById(id);
        return byId;
    }

    @GetMapping("/test")
    public Orders test(){
        Orders byId = ordersService.getById(1L);
        return byId;
    }

    /**
     * 下单
     * @param jsonObject
     * @return
     */
    @PostMapping("/placeAnOrder")
    public String placeAnOrder(@RequestBody JSONObject jsonObject,HttpServletRequest request){
        Boolean result = ordersService.placeAnOrder(jsonObject);
        if(result){
            return "下单成功";
        }
        return "下单失败";
    }
}
