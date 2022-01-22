package com.ssy.project.example.repository.base_repository;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssy.project.example.model.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * 通用操作方法
 * @param <DO>
 */
public interface BaseRepository<DO extends BaseModel>{

    /**
     * 保存
     *
     * @param data DO
     * @return id 值
     */
    Boolean saveOrUpdateConstruct(DO data);

    /**
     * 通过 id 获取数据
     *
     * @param id id
     * @return 实体
     */
    DO selectById(Long id);


    /**
     * 根据id逻辑删除数据,并带字段填充功能。注意入参是 entity !!! ,如果字段没有自动填充,就只是单纯的逻辑删除。@see MybatisObjectHandler MybatisConfiguration
     * @param t
     * @return
     */
    Boolean deleteByIdWithFill(DO da);


    Page<DO> selectPage(Page page, Wrapper queryWrapper);


    /**
     * 批量删除
     * @param idList
     * @return
     */
    default Boolean deleteBatchIds(List<? extends Serializable> idList){
        throw new RuntimeException("内部服务异常");
    }


    /**
     *  批量保存
     *
     * @param entityList
     */
    default Boolean saveBatchList(List<DO> entityList){
        throw new RuntimeException("内部服务异常");
    }

}
