package com.ssy.project.example.repository.impl;



import com.ssy.project.example.mapper.OrdersMapper;
import com.ssy.project.example.model.Orders;
import com.ssy.project.example.repository.OrdersRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-06 17:23
 */
@Repository
public class OrdersRepositoryImpl extends BaseRepositoryImpl<OrdersMapper, Orders> implements OrdersRepository {



}
