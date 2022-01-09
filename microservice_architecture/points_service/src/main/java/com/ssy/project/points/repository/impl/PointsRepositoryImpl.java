package com.ssy.project.points.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ssy.project.points.mapper.PointsMapper;
import com.ssy.project.points.model.Points;
import com.ssy.project.points.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-07 09:46
 */
@Repository
public class PointsRepositoryImpl extends BaseRepositoryImpl<PointsMapper, Points> implements PointsRepository {

    @Autowired
    PointsMapper pointsMapper;

    @Override
    public Points queryByUid(String uid) {
        QueryWrapper<Points> pointsQueryWrapper = new QueryWrapper<>();
        pointsQueryWrapper.lambda().eq(Points::getUid,uid);
        Points points = pointsMapper.selectOne(pointsQueryWrapper);
        return points;
    }
}
