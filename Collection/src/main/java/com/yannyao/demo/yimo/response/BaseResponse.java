package com.yannyao.demo.yimo.response;

import com.yannyao.demo.yimo.Exception.ApiErrors;
import com.yannyao.demo.yimo.Exception.BusinessException;
import lombok.Data;

@Data
public class BaseResponse<T> {
    private String errMsg;
    private String error;
    private int result;
    private T data;


    public BaseResponse() {
    }

    public BaseResponse(T data){
        this.data = data;
    }

    public BaseResponse(BusinessException e) {
        this(e.getResult(), e.getError(),e.getErrMsg());
    }


    public BaseResponse(ApiErrors errors) {
        this(errors.getResult(), errors.getError(), errors.getErrMsg());
    }

    public BaseResponse(int result, String error, String errMsg) {
        this.result = result;
        this.error = error;
        this.errMsg = errMsg;
    }

    public BaseResponse setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return getResult() == 0;
    }

}
