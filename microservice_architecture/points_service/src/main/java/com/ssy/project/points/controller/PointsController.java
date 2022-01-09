package com.ssy.project.points.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ssy.project.points.model.Points;
import com.ssy.project.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiJun
 * @date 2022-01-07 10:31
 */
@RestController
@RequestMapping("points")
public class PointsController {


    @Autowired
    PointsService pointsService;

    @PostMapping("/AddPoints")
    public Boolean savePoints(@RequestBody JSONObject jsonObject){
       int a=  10/0;
        Points points = JSON.parseObject(jsonObject.toString(), Points.class);
        return pointsService.savePoints(points);
    }

}
