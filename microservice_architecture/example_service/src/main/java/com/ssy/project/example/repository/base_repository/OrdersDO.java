package com.ssy.project.example.repository.base_repository;

import com.ssy.project.example.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author LiJun
 * @since 2022-01-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrdersDO extends BaseModel {

    /**
     * 产品id
     */
    private Long pid;

    /**
     * 用户id
     */
    private String uid;

}
