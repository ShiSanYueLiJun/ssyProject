package com.ssy.project.order.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.feign.PointsFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @Author:LiJun
 * @Date: 2022/1/8 14:33
 */
@Log4j2
@Component
public class PointsFeignBack implements PointsFeign {
    @Override
    public Boolean savePoints(JSONObject jsonpObject) {
        //TODO 记录加积分失败的操作，做自动补偿
        log.info("添加积分失败:{}",jsonpObject);
        return false;
    }
}
