package com.ssy.project.example.repository.base_repository;

import com.ssy.project.example.model.Orders;
import org.mapstruct.Mapper;

/**
 * @author LiJun
 * @date 2022-01-12 16:41
 */
@Mapper(componentModel = "spring")
public interface OrdersConvert extends BaseConvert<Orders, OrdersDO>{
}
