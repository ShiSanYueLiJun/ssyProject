package com.ssy.project.points.mapper;

import com.ssy.project.points.model.Points;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 积分 Mapper 接口
 * </p>
 *
 * @author LiJun
 * @since 2022-01-07
 */
@Mapper
public interface PointsMapper extends CommonMapper<Points> {

}
