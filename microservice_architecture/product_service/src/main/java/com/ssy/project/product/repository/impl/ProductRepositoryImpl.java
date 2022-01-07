package com.ssy.project.product.repository.impl;

import com.ssy.project.product.mapper.ProductsMapper;
import com.ssy.project.product.model.Products;
import com.ssy.project.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-07 10:43
 */
@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<ProductsMapper, Products> implements ProductRepository {
}
