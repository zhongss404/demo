package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 43799 on 2018/8/12.
 */
@Component
@Order(11)
public class MyFilter implements Filter {

    public static final Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.error("MyFilter过滤器初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.error("MyFilter 执行过滤...");
        Long startTime = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        logger.error("MyFilter 业务执行时间：" + (new Date().getTime() - startTime));
    }

    @Override
    public void destroy() {
        logger.error("MyFilter 过滤器销毁...");
    }
}
