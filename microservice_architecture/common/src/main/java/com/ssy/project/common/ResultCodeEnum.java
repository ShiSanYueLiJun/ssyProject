package com.ssy.project.common;

/**
 * @author LiJun
 * @date 2022-01-11 12:19
 */
public enum  ResultCodeEnum {


    SUCCESS("200","成功",Status.S),

    FAIL("202","业务处理失败",Status.F),

    UNKNOWN("201","未知异常",Status.U),

    VERIFY_EXCEPTION("401","检验异常",Status.F),

    NOT_FOUND_EXCEPTION("404","服务找不到异常",Status.F),

    TIMEOUT_EXCEPTION("504","请求超时,稍后再试",Status.F);


    private String code;

    private String description;

    private Status resultStatus;

    ResultCodeEnum(String code, String description, Status resultStatus) {
        this.code = code;
        this.description = description;
        this.resultStatus = resultStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Status resultStatus) {
        this.resultStatus = resultStatus;
    }
}
