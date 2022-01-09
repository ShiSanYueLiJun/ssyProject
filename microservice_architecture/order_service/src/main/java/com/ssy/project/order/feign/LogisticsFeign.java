package com.ssy.project.order.feign;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.feign.fallback.LogisticsFeignBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author:LiJun
 * @Date: 2022/1/8 14:02
 */
@FeignClient(name = "logistics-service",fallback = LogisticsFeignBack.class)
public interface LogisticsFeign {


    /**
     * 保存物流
     * @param jsonObject
     * @return
     */
    @PostMapping("/logistics/saveLogistics")
    public Boolean saveLogistics(JSONObject jsonObject);


}
