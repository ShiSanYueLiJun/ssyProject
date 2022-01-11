package com.ssy.project.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * @author LiJun
 * @date 2022-01-11 11:25
 */
public abstract class ResultModelSupport<T> implements ResultModel<T> {

    private static final long serialVersionUID = -7339505825517995907L;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 消息
     */
    private Message message;

    /**
     * 返回结果
     */
    private T data;

    /**
     * 是否可以重试
     * false代表不能重试，true可选择重试，也可选择不再重试
     */
    protected boolean             needRetry;

    /**
     * 扩展信息
     */
    protected Map<String, String> extendInfo;

    /**
     * 摘要日志需要输出的值，null值将被-代替
     *
     * @return
     */
    public abstract Object[] getDigetValues();

    /**
     * 获取摘要日志
     *
     * @return
     */
    public String getDigestLog() {
        Object[] values = getDigetValues();
        if (null == values) {
            return "-";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = Arrays.asList(values).iterator();
        if (it.hasNext()) {
            Object value = it.next();
            sb.append(null == value ? "-" : value.toString());
            while (it.hasNext()) {
                Object val = it.next();
                sb.append(",").append(null == val ? "-" : val.toString());
            }
            return sb.toString();
        } else {
            return "-";
        }
    }

    /**
     * Getter method for property <tt>extendInfo</tt>.
     *
     * @return property value of extendInfo
     */
    public Map<String, String> getExtendInfo() {
        return extendInfo;
    }

    /**
     * Setter method for property <tt>extendInfo</tt>.
     *
     * @param extendInfo value to be assigned to property extendInfo
     */
    public void setExtendInfo(Map<String, String> extendInfo) {
        this.extendInfo = extendInfo;
    }

    /**
     * Is needRetry boolean.
     *
     * @return the boolean
     */
    public boolean isNeedRetry() {
        return needRetry;
    }

    /**
     * Sets set success.
     *
     * @param needRetry the needRetry
     */
    public void setNeedRetry(boolean needRetry) {
        this.needRetry = needRetry;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }


    @Override
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
