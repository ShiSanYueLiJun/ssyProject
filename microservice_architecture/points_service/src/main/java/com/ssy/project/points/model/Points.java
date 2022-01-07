package com.ssy.project.points.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分
 * </p>
 *
 * @author LiJun
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Points extends BaseModel {
    /**
     * 用户id
     */
    private String uid;

    /**
     * 积分
     */
    private Integer point;

}
