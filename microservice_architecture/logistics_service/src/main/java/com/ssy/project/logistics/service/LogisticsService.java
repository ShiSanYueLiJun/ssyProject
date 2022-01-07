package com.ssy.project.logistics.service;

import com.ssy.project.logistics.model.Logistics;

/**
 * @author LiJun
 * @date 2022-01-07 10:12
 */
public interface LogisticsService {


    /**
     * 保存
     * @param logistics
     * @return
     */
    public Boolean save(Logistics logistics);

}
