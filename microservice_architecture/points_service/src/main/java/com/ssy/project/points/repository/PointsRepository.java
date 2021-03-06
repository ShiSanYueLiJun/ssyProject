package com.ssy.project.points.repository;

import com.ssy.project.points.model.Points;

/**
 * @author LiJun
 * @date 2022-01-07 09:46
 */
public interface PointsRepository extends BaseRepository<Points>{

    /**
     * 查询用户积分
     * @param uid
     * @return
     */
    public Points queryByUid(String uid);

}
