package com.ssy.project.product.service;

import com.ssy.project.product.model.Products;

/**
 * @author LiJun
 * @date 2022-01-07 10:42
 */
public interface ProductService {

    /**
     * 减少库存
     * @param products
     * @return
     */
    public Boolean deductStock(Products products);


}
