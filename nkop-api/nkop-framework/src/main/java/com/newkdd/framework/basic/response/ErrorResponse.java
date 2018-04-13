package com.newkdd.framework.basic.response;

import com.newkdd.framework.basic.BasicResponse;

/**
 * Created by Mike on 2018/4/12.
 */
public class ErrorResponse  extends BasicResponse {

    /** 错误码*/
    private String code;
    /** 错误提示 */
    private String error;
    /** 堆栈错误 */
    private String stack;

    public ErrorResponse(){

    }

    public ErrorResponse(String code,String error){
        this.error = error;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
