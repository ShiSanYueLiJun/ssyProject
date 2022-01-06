package com.ssy.project.order.repository.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.project.order.mapper.CommonMapper;
import com.ssy.project.order.model.BaseModel;
import com.ssy.project.order.repository.BaseRepository;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的操作方法
 * @author LiJun
 * @date 2021-12-27 16:50
 */
public class BaseRepositoryImpl<M extends CommonMapper,T extends BaseModel> extends ServiceImpl<CommonMapper<T>,T> implements BaseRepository<T> {


    @Override
    public Boolean saveOrUpdateConstruct(T data) {
        if (data.getId() == null) {
            super.save(data);
        } else {
//            T oldModel = selectById(data.getId());
//            deleteByIdWithFill(data);
            //insert into old record
//            oldModel.setId(null);
//            super.save(oldModel);
//            data.setId(oldModel.getId());
            // data.setGmtDelete(null);     刪除
            super.updateById(data);
        }
        return true;
    }



    @Override
    public T selectById(Long id) {
        return super.getById(id);
    }

    @Override
    public Boolean deleteByIdWithFill(T t) {
        //UPDATE xxx SET gmt_modified=?,gmt_delete=?,modifier=?,modifier_name=?,is_valid='0' WHERE claim_tag_id=? AND is_valid='1'
     //   t.setGmtDelete(new Date());
        int i = super.getBaseMapper().deleteByIdWithFill(t);
        return i > 0;
    }


    @Override
    public Page<T> selectPage(Page page, Wrapper queryWrapper) {
        return super.page(page,queryWrapper);
    }



    @Override
    public Boolean deleteBatchIds(List<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }


    @Override
    public Boolean saveBatchList(List<T> entityList) {
        return super.saveBatch(entityList);
    }
}
