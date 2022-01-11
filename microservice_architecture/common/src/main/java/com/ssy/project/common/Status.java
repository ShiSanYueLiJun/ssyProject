package com.ssy.project.common;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiJun
 * @date 2022-01-11 11:27
 */
public enum Status implements Serializable {

    /**
     * 成功
     */
    S(1,"SUCCESS"),

    /**
     * 失败
     */
    F(2,"FAIL"),

    /**
     * 未知
     */
    U(3,"UNKNOWN");

    private  Integer value;

    private String description;

    Status(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }


    private static final Map<Integer,Status> ENUM_MAP;

    static {
        Map<Integer, Status> map = new HashMap<>();
        for(Status element :Status.values()){
            map.put(element.getValue(),element);
        }
        ENUM_MAP= Collections.unmodifiableMap(map);
    }

    public static  Status get(Integer value){
        if(value!=null){
            return ENUM_MAP.get(value);
        }
        return null;
    }

}
