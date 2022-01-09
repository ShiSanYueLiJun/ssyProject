package com.ssy.project.points.service.impl;

import com.ssy.project.points.model.Points;
import com.ssy.project.points.repository.PointsRepository;
import com.ssy.project.points.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        Points point = pointsRepository.queryByUid(points.getUid());
        if(!StringUtils.isEmpty(point)){
            point.setPoint(point.getPoint()+points.getPoint());
            return pointsRepository.saveOrUpdateConstruct(point);
        }
        points.setPoint(10);
        return pointsRepository.saveOrUpdateConstruct(points);
    }
}
