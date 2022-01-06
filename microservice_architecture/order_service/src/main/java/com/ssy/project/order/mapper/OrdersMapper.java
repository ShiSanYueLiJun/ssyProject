package com.ssy.project.order.mapper;

import com.ssy.project.order.model.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author LiJun
 * @since 2022-01-06
 */
@Mapper
public interface OrdersMapper extends CommonMapper<Orders> {

}
