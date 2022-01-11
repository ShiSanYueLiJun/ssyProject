package com.ssy.project.common;

/**
 * @author LiJun
 * @date 2022-01-11 11:22
 */
public interface ResultModel<T> extends Result{
    /**
     * 返回结果模型
     *
     * @return
     */
    T getData();

    /**
     * 页面编码，从1开始
     *
     * @return
     */
    int getPageIndex();

    /**
     * 记录总数量
     * <pre>
     *     有时可能只要分页数据，不要总数
     * </pre>
     *
     * @return
     */
    Integer getTotalCount();

    /**
     * 每页大小
     *
     * @return
     */
    int getPageSize();
}
