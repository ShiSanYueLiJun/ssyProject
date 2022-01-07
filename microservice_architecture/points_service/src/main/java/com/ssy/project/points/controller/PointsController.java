package com.ssy.project.points.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ssy.project.points.model.Points;
import com.ssy.project.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/points")
    public Boolean savePoints(JSONPObject jsonpObject){
        Points points = JSON.parseObject(jsonpObject.toString(), Points.class);
        return pointsService.savePoints(points);
    }

}
