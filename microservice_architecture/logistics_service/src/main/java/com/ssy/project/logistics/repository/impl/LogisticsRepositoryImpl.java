package com.ssy.project.logistics.repository.impl;

import com.ssy.project.logistics.mapper.LogisticsMapper;
import com.ssy.project.logistics.model.Logistics;
import com.ssy.project.logistics.repository.LogisticsRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LiJun
 * @date 2022-01-07 10:05
 */
@Repository
public class LogisticsRepositoryImpl extends BaseRepositoryImpl<LogisticsMapper, Logistics> implements LogisticsRepository {
}
