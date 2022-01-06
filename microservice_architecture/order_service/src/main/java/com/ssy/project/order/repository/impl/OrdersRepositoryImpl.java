package com.ssy.project.order.repository.impl;


import com.ssy.project.order.mapper.OrdersMapper;
import com.ssy.project.order.model.Orders;
import com.ssy.project.order.repository.OrdersRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-06 17:23
 */
@Repository
public class OrdersRepositoryImpl extends BaseRepositoryImpl<OrdersMapper, Orders> implements OrdersRepository {



}
