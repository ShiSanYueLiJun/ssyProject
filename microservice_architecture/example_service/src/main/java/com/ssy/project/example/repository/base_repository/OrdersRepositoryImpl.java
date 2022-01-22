package com.ssy.project.example.repository.base_repository;



import com.ssy.project.example.model.Orders;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-06 17:23
 */
@Repository
public class OrdersRepositoryImpl extends BaseRepositoryImpl<OrdersDO, Orders,OrdersConvert> implements OrdersRepository {


    @Override
    public Boolean save(OrdersDO ordersDO) {
        return super.saveOrUpdateConstruct(ordersDO);
    }
}
