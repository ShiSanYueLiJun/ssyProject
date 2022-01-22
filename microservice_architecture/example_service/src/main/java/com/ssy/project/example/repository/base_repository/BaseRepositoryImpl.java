package com.ssy.project.example.repository.base_repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssy.project.example.mapper.CommonMapper;
import com.ssy.project.example.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * 通用的操作方法
 * @author LiJun
 * @date 2021-12-27 16:50
 */
public class BaseRepositoryImpl<DO extends BaseModel,PO extends BaseModel,B extends BaseConvert<PO,DO>> extends ServiceImpl<CommonMapper<PO>,PO> implements BaseRepository<DO> {

    @Autowired
    B convert;

    @Override
    public Boolean saveOrUpdateConstruct(DO data) {
        if (data.getId() == null) {
            PO po = convert.toPO(data);
            super.save(po);
        }else if(data.getValid()!=null&&!data.getValid()){
            this.deleteByIdWithFill(data);
        }
        else {
//            T oldModel = selectById(data.getId());
//            deleteByIdWithFill(data);
            //insert into old record
//            oldModel.setId(null);
//            super.save(oldModel);
//            data.setId(oldModel.getId());
            // data.setGmtDelete(null);     刪除

            super.updateById(convert.toPO(data));
        }
        return true;
    }



    @Override
    public DO selectById(Long id) {
        return convert.toDO(super.getById(id));
    }

    @Override
    public Boolean deleteByIdWithFill(DO data) {
        return super.baseMapper.deleteByIdWithFill(convert.toPO(data))>0;
    }



    @Override
    public Page<DO> selectPage(Page page, Wrapper queryWrapper) {
        Page<PO> pageData = super.page(page, queryWrapper);
        return convert.toDOPage(pageData);
    }



    @Override
    public Boolean deleteBatchIds(List<? extends Serializable> idList) {
        return super.removeByIds(idList);
    }


    @Override
    public Boolean saveBatchList(List<DO> entityList) {
        return super.saveBatch(convert.toPOList(entityList));
    }
}
