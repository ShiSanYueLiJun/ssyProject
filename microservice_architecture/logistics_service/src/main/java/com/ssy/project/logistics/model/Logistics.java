package com.ssy.project.logistics.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 物流
 * </p>
 *
 * @author LiJun
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Logistics extends BaseModel {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 产品id
     */
    private Long pid;
}
