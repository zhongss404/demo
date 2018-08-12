package com.example.demo.config;

import com.example.demo.filter.TimeFilter;
import com.example.demo.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 43799 on 2018/8/12.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private MyInterceptor myInterceptor; //注入自定义拦截器

    /**
     * 使拦截器起作用
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor);
    }

    /**
     * 将第三方filter加入到spring容器
     * @return
     */
    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();  //实例第三方filter

        registrationBean.setFilter(timeFilter);  //加载filter
        registrationBean.setOrder(12);  //设置filter执行顺序（值越大，越靠后执行)

        //指定该filter过滤哪些url
        List<String> urls = new ArrayList<>();
        urls.add("/user");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}
