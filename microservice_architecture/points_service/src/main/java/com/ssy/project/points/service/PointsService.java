package com.ssy.project.points.service;

import com.ssy.project.points.model.Points;

/**
 * @author LiJun
 * @date 2022-01-07 10:28
 */
public interface PointsService {


    /**
     * 保存积分
     * @param points
     * @return
     */
    public Boolean savePoints(Points points);
}
