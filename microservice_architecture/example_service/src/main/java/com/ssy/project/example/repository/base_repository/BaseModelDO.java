package com.ssy.project.example.repository.base_repository;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LiJun
 * @date 2021-12-27 16:44
 */
@Data
@Accessors(chain = true)
public class BaseModelDO implements Serializable {

    private static final long  serialVersionUID = 1L;

    private Long id;

    private Boolean valid;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;


}
