package com.ssy.project.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.feign.LogisticsFeign;
import com.ssy.project.order.feign.PointsFeign;
import com.ssy.project.order.feign.ProductFeign;
import com.ssy.project.order.model.Orders;
import com.ssy.project.order.repository.OrdersRepository;
import com.ssy.project.order.service.OrdersService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJun
 * @date 2022-01-06 17:22
 */
@Service
@Log4j2
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductFeign  productFeign;

    @Autowired
    PointsFeign pointsFeign;

    @Autowired
    LogisticsFeign logisticsFeign;

    @Override
    public Orders getById(Long id) {
    return ordersRepository.selectById(id);
    }

    @GlobalTransactional
    @Override
    public Boolean placeAnOrder(JSONObject jsonObject) {
        Orders orders = new Orders();
        orders.setPid(jsonObject.getLong("pid"));
        orders.setUid(jsonObject.getString("uid"));
//        try {
            //下单
            ordersRepository.saveOrUpdateConstruct(orders);
            //库存
            productFeign.deductStock(jsonObject);
            //积分
            JSONObject pointsObject = new JSONObject();
            pointsObject.put("uid",orders.getUid());
            pointsObject.put("point",jsonObject.getInteger("number")*10);
            pointsFeign.savePoints(pointsObject);
            //物流
            JSONObject logistics = new JSONObject();
            logistics.put("uid",orders.getUid());
            logistics.put("pid",orders.getPid());
            logisticsFeign.saveLogistics(jsonObject);
            return  true;
//        } catch (Exception e) {
//            log.info("下单异常:{}",e);
//        }
//        return false;
    }
}
