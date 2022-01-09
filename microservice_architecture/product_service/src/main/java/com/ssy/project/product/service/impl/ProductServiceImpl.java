package com.ssy.project.product.service.impl;

import com.ssy.project.product.model.Products;
import com.ssy.project.product.repository.ProductRepository;
import com.ssy.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJun
 * @date 2022-01-07 10:45
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Boolean deductStock(Products products) {
        Products product = productRepository.selectById(products.getId());
        if(product.getStock()<=0){
            throw new RuntimeException("库存不足!");
        }
        if(product.getStock()<products.getStock()){
            throw new RuntimeException("库存不足,请减少购买数量!");
        }
        product.setStock(product.getStock()-products.getStock());
        return productRepository.saveOrUpdateConstruct(product);
    }
}
