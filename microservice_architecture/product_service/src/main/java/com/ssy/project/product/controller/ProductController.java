package com.ssy.project.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssy.project.product.model.Products;
import com.ssy.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiJun
 * @date 2022-01-07 10:47
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 减少库存
     * @param jsonObject
     * @return
     */
    @PostMapping("/deductStock")
    public Boolean deductStock(@RequestBody JSONObject jsonObject){
        Products products = new Products();
        products.setStock(jsonObject.getInteger("number")).setId(jsonObject.getLong("pid"));
        return productService.deductStock(products);
    }
}
