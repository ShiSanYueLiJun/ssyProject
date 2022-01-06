package com.ssy.project.example.model;

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
public class Orders extends BaseModel  {

    /**
     * 产品id
     */
    private Long pid;

    /**
     * 用户id
     */
    private String uid;

}
