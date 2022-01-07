package com.ssy.project.points.service.impl;

import com.ssy.project.points.model.Points;
import com.ssy.project.points.repository.PointsRepository;
import com.ssy.project.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJun
 * @date 2022-01-07 10:28
 */
@Service
public class PointsServiceImpl implements PointsService {

    @Autowired
    PointsRepository pointsRepository;

    @Override
    public Boolean savePoints(Points points) {
        return pointsRepository.saveOrUpdateConstruct(points);
    }
}
