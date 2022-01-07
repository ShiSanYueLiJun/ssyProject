package com.ssy.project.product.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssy.project.product.model.Products;
import com.ssy.project.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJun
 * @date 2022-01-07 10:47
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PutMapping("/savaProduct/{product}")
    public Boolean savaProduct(@PathVariable("product") JSONObject jsonObject){
        Products products = JSON.parseObject(jsonObject.toJSONString(), Products.class);
        return productService.savaProduct(products);
    }
}
