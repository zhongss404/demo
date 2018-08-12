package com.example.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 43799 on 2018/8/12.
 */

@Component
public class MyInterceptor implements HandlerInterceptor {
    public static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.error("pre handle .... " );
        logger.error("请求对应的控制器名称：" + ((HandlerMethod)handler).getBean().getClass().getName());
        logger.error("请求对应的方法：" + ((HandlerMethod)handler).getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        logger.error("post handle ....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        logger.error("after completion ...");
        logger.error("exception ===> " + (ex != null ? ex.getLocalizedMessage() : "没有异常"));
    }
}
