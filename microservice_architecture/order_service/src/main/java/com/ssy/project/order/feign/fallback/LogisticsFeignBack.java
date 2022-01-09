package com.ssy.project.order.feign.fallback;

import com.alibaba.fastjson.JSONObject;
import com.ssy.project.order.feign.LogisticsFeign;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @Author:LiJun
 * @Date: 2022/1/8 14:06
 */
@Log4j2
@Component
public class LogisticsFeignBack implements LogisticsFeign {



    @Override
    public Boolean saveLogistics(JSONObject jsonObject) {
        log.info("保存物流失败:{}",jsonObject);
        return false;
    }
}
