package com.ssy.project.example.repository.base_repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssy.project.example.model.BaseModel;

import java.util.List;

/**
 * do/po转换
 * DO extends 业务的公共内 可以和BaseModel相同
 * @author LiJun
 * @date 2022-01-12 16:18
 */
public interface BaseConvert<PO extends BaseModel,DO extends BaseModel> {

    PO toPO(DO domain);

    DO toDO(PO entity);

    List<PO> toPOList(List<DO> doList);

    List<DO> toDOList(List<PO> poList);

    Page<PO> toPOPage(Page<DO> doPage);

    Page<DO> toDOPage(Page<PO> poPage);
}
