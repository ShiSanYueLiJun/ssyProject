package com.ssy.project.order.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author:LiJun
 * @Date: 2022/1/8 14:02
 */
@FeignClient(name = "product-service")
public interface ProductFeign {

    /**
     * 减少库存
     * @param jsonObject
     * @return
     */
    @PostMapping("/product/deductStock")
    public Boolean deductStock(JSONObject jsonObject);

}
