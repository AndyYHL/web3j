package com.hx.eplate.trafficdata.query.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018-03-13.
 */
@Configuration   //标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new ControllerInterceptor()).addPathPatterns("/**");  //对来自/** 这个链接来的请求进行拦截
    }
}
