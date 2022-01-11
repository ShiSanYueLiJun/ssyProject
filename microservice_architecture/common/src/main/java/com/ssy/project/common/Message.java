package com.ssy.project.common;

/**
 * @author LiJun
 * @date 2022-01-11 11:40
 */

public class Message {

    private String code;

    private String  message;

    public Message(String message) {
        this.message = message;
    }

    public Message(ResultCodeEnum resultCodeEnum) {
        this.message = resultCodeEnum.getDescription();
        this.code = resultCodeEnum.getCode();
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
