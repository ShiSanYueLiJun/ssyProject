package com.ssy.project.order.service;

import com.ssy.project.order.model.Orders;

/**
 * @author LiJun
 * @date 2022-01-06 17:22
 */
public interface OrdersService {

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Orders getById(Long id);


}
