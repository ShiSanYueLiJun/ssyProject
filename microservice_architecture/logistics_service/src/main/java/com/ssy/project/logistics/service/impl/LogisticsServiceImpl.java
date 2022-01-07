package com.ssy.project.logistics.service.impl;

import com.ssy.project.logistics.model.Logistics;
import com.ssy.project.logistics.repository.LogisticsRepository;
import com.ssy.project.logistics.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiJun
 * @date 2022-01-07 10:14
 */
@Service
public class LogisticsServiceImpl implements LogisticsService {


    @Autowired
    LogisticsRepository logisticsRepository;


    @Override
    public Boolean save(Logistics logistics) {
        return logisticsRepository.saveOrUpdateConstruct(logistics);
    }
}
