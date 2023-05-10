package com.ssy.project.points.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssy.project.points.model.Points;
import com.ssy.project.points.service.PointsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author LiJun
 * @date 2022-01-07 10:31
 */
@RestController
@RequestMapping("points")
public class PointsController {

    private final static Logger logger = LoggerFactory.getLogger(PointsController.class);
    @Autowired
    PointsService pointsService;

    @PostMapping("/AddPoints")
    public Boolean savePoints(@RequestBody JSONObject jsonObject){
       int a=  10/0;
        Points points = JSON.parseObject(jsonObject.toString(), Points.class);
        return pointsService.savePoints(points);
    }

    @GetMapping("/testLog")
    public void savePoints(){
        Random random = new Random();
        logger.warn(String.format("十三月warn:%s,ssy",random.nextInt(10000)));
        logger.info(String.format("十三月info:%s,ssy",random.nextInt(10000)));
        logger.error(String.format("十三月error:%s,ssy",random.nextInt(10000)));
        logger.debug(String.format("十三月debug:%s,ssy",random.nextInt(10000)));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",random.nextInt(10000));
        jsonObject.put("十三月"+random.nextInt(10000),random.nextInt(10000));
        logger.info(jsonObject.toString());
    }
    @GetMapping("/testLog1")
    public void savePoints1(){
        int a = 10/0;
    }
}
