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
    public Boolean savaProduct(Products products) {
        return productRepository.saveOrUpdateConstruct(products);
    }
}
