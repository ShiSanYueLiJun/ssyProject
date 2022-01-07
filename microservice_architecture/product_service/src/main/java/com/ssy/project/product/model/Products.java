package com.ssy.project.product.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author LiJun
 * @since 2022-01-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Products extends BaseModel{

    /**
     * 产品名
     */
    private String productName;

    /**
     * 库存
     */
    private Integer stock;


}
