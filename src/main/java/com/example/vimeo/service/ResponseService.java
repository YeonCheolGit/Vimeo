package com.example.vimeo.service;

import com.example.vimeo.advice.ResponseEnum;
import com.example.vimeo.model.response.CommonResult;
import com.example.vimeo.model.response.SingleResult;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    private void setSuccessResult(CommonResult result) {
        result.setSuccess(ResponseEnum.DEFAULT_SUCCESS.isCheck());
        result.setCode(ResponseEnum.DEFAULT_SUCCESS.getCode());
        result.setMsg(ResponseEnum.DEFAULT_SUCCESS.getMsg());
        result.setStatus(ResponseEnum.DEFAULT_SUCCESS.getStatus());
    }

    public CommonResult getDefaultException() {
        CommonResult result = new CommonResult();
        result.setSuccess(ResponseEnum.DEFAULT_FAIL.isCheck());
        result.setCode(ResponseEnum.DEFAULT_FAIL.getCode());
        result.setMsg(ResponseEnum.DEFAULT_FAIL.getMsg());
        result.setStatus(ResponseEnum.DEFAULT_FAIL.getStatus());
        return result;
    }

    public CommonResult getWrongURLException() {
        CommonResult result = new CommonResult();
        result.setSuccess(ResponseEnum.BAD_REQUEST.isCheck());
        result.setCode(ResponseEnum.BAD_REQUEST.getCode());
        result.setMsg(ResponseEnum.BAD_REQUEST.getMsg());
        result.setStatus(ResponseEnum.BAD_REQUEST.getStatus());
        return result;
    }

}
