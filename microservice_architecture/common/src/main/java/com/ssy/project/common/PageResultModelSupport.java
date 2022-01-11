package com.ssy.project.common;

import com.alibaba.fastjson.JSONObject;

/**
 * @author LiJun
 * @date 2022-01-11 11:24
 * 分页公用
 */
public class PageResultModelSupport<T> extends ResultModelSupport {

    /**
     * 总数
     * <pre>
     *     有时可能只要分页数据，不要总数
     * </pre>
     */
    private Integer totalCount;

    /**
     * 分页数
     */
    private int pageSize;

    /**
     * 页码
     */
    private int pageIndex;

    // ps: 完全没必要，就用父类的data，具体集合放到业务层自己的DTO里面
//    /**
//     * 返回结果
//     */
//    private List<T> data;

    public PageResultModelSupport() {
    }

    @Override
    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public Object[] getDigetValues() {
        return new Object[0];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PageResultModelSupport{");
        builder.append("totalCount=").append(totalCount);
        builder.append(", pageSize=").append(pageSize);
        builder.append(", pageIndex=").append(pageIndex);
        if (getStatus() != null) {
            builder.append(", status=").append(getStatus());
        }
        if (getMessage() != null) {
            builder.append(", code=").append(getMessage().getCode());
            builder.append(", message=").append(getMessage().getMessage());
            builder.append(", description=").append(getMessage().getMessage());
        }
        builder.append(", data=").append(JSONObject.toJSONString(getData()));
        return builder.toString();
    }
}