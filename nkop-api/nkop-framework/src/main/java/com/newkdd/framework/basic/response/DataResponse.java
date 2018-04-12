package com.newkdd.framework.basic.response;

import com.newkdd.framework.basic.BasicResponse;

/**
 * Created by Mike on 2017/8/25.
 */
public class DataResponse<T> extends BasicResponse {

    /**返回数据*/
    protected T data;

    public DataResponse(){

    }

    public DataResponse(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
