package com.ssy.project.order.service.impl;

import com.ssy.project.order.model.Orders;
import com.ssy.project.order.repository.OrdersRepository;
import com.ssy.project.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJun
 * @date 2022-01-06 17:22
 */
@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    OrdersRepository ordersRepository;


    @Override
    public Orders getById(Long id) {
    return ordersRepository.selectById(id);
    }
}
