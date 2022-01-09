package com.ssy.project.order.feign;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.feign.fallback.PointsFeignBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author:LiJun
 * @Date: 2022/1/8 14:03
 */
@FeignClient(value = "points-service",fallback = PointsFeignBack.class)
public interface PointsFeign {

    /**
     * 添加积分
     * @param jsonpObject
     * @return
     */
    @PostMapping("/points/AddPoints")
    public Boolean savePoints(JSONObject jsonpObject);

}
