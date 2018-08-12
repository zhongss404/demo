package com.example.demo.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

/**
 * Created by 43799 on 2018/8/12.
 * 第三方过滤器
 */

public class TimeFilter implements Filter {

    public static final Logger logger = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.error("TimeFilter 过滤器初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.error("TimeFilter 执行过滤...");
        Long startTime = new Date().getTime();
        filterChain.doFilter(servletRequest,servletResponse);
        logger.error("TimeFilter 业务执行时间：" + (new Date().getTime() - startTime));
    }

    @Override
    public void destroy() {
        logger.error("TimeFilter 过滤器销毁...");
    }
}
