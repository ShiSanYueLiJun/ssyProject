package com.ssy.project.points.repository.impl;

import com.ssy.project.points.mapper.PointsMapper;
import com.ssy.project.points.model.Points;
import com.ssy.project.points.repository.PointsRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-07 09:46
 */
@Repository
public class PointsRepositoryImpl extends BaseRepositoryImpl<PointsMapper, Points> implements PointsRepository {
}
