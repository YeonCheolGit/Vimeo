package com.example.vimeo.advice;

import com.example.vimeo.advice.exception.WrongURL;
import com.example.vimeo.model.response.CommonResult;
import com.example.vimeo.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class GlobalException {

    private ResponseService responseService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(Exception e) {
        return responseService.getDefaultException();
    }

    // 잘 못된 URL 입력 시 발생 합니다.
    @ExceptionHandler(WrongURL.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CommonResult wrongURL(WrongURL e) {
        return responseService.getWrongURLException();
    }
}
