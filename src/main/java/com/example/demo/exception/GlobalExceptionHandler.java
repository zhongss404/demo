package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 43799 on 2018/8/12.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    public Map<String,Object> handleUserNotExistException(UserNotExistException ex){
        Map<String,Object> exMessage = new HashMap<>();  //自定义异常json
        exMessage.put("userId",ex.getUserId());
        exMessage.put("message",ex.getMessage());
        return exMessage;
    }
}
