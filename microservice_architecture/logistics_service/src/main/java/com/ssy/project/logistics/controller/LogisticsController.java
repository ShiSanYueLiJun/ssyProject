package com.ssy.project.logistics.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ssy.project.logistics.model.Logistics;
import com.ssy.project.logistics.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJun
 * @date 2022-01-07 10:15
 */
@RestController
@RequestMapping("logistics")
public class LogisticsController {

    @Autowired
    LogisticsService logisticsService;

    @PostMapping("/saveLogistics")
    public Boolean saveLogistics(@RequestBody JSONObject jsonObject){
        Logistics logistics = JSON.parseObject(jsonObject.toJSONString(), Logistics.class);
        return  logisticsService.save(logistics);

    }
}
