package com.newkdd.framework.basic;

import java.io.Serializable;

/**
 * Created by Mike on 2017/8/25.
 */
public class BasicResponse implements Serializable{
    /**状态码*/
    protected Integer code = 200;
    /**描述信息*/
    protected String message = "success";

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
