package com.ssy.project.points.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 逻辑删除方法
 * @author LiJun
 * @date 2021-12-27 16:50
 */
public interface CommonMapper<T> extends BaseMapper<T> {

    /**
     * 逻辑删除并填充字段
     * @param t
     * @return
     */
    int  deleteByIdWithFill(T t);

}
