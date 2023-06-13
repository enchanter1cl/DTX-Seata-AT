package com.erato.goodsservice.config;

import com.erato.cloud.common.dto.Result;
import com.erato.cloud.common.exception.NewBeeMallException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


@RestControllerAdvice
public class GoodsServiceExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Object bindException(BindException e) {
        Result result = new Result();
        result.setResultCode(510);
        BindingResult bindingResult = e.getBindingResult();
        result.setMessage(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object bindException(MethodArgumentNotValidException e) {
        Result result = new Result<>();
        result.setResultCode(510);
        BindingResult bindingResult = e.getBindingResult();
        result.setMessage(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e, HttpServletRequest req) {
        Result result = new Result();
        result.setResultCode(500);
        //区分是否是自定义异常
        if (e instanceof NewBeeMallException) {
            result.setMessage(e.getMessage());
            if ("ADMIN_NOT_LOGIN_ERROR".equals(e.getMessage()) || "ADMIN_TOKEN_EXPIRE_ERROR".equals(e.getMessage())) {
                result.setResultCode(419);
            }
        } else {
            e.printStackTrace();
            result.setMessage("未知  非NewBeeMallExcep 自定义异常");
        }
        return result;
    }
}
