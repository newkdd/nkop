package com.newkdd.framework.basic.response;

import com.newkdd.framework.basic.BasicResponse;

/**
 * Created by Mike on 2018/4/12.
 */
public class ErrorResponse  extends BasicResponse {

    /** 错误码*/
    private String code;
    /** 错误提示 */
    private String message;
    /** 堆栈错误 */
    private String stack;

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

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
