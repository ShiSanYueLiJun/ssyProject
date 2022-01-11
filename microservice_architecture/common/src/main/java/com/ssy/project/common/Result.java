package com.ssy.project.common;

/**
 * @author LiJun
 * @date 2022-01-11 11:20
 * 返回结果模型
 */
public interface Result {
    /**
     * 返回状态
     *
     * @return
     */
    Integer getStatus();

    /**
     * 返回消息
     *
     * @return
     */
    Message getMessage();
}
