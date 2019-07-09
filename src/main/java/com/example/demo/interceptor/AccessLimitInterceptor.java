package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 43799 on 2019/7/9.
 */
@Component
public class AccessLimitInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if(accessLimit != null){

            }
        }
        return false;
    }

    private void render(HttpServletResponse response,String result) throws IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(result.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }

}
