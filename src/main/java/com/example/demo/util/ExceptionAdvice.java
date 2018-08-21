package com.example.demo.util;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/*
* 统一异常处理
* */
@ControllerAdvice
public class ExceptionAdvice {
    //无权限时的异常处理
    @ExceptionHandler({AuthorizationException.class})
    @ResponseBody
    public Map<String,Object> handleException(Exception e){
        return ResponseUtil.errorResponse(Common.Error_403,Common.Error_MSG_403,null);
    }
}
