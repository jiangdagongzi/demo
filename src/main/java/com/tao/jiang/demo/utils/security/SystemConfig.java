package com.tao.jiang.demo.utils.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SystemConfig extends WebMvcConfigurationSupport {

    @Autowired
    private ParamInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor). addPathPatterns("/**").
                excludePathPatterns("/login","/register/**","/hello"); //设置不拦截的请求地址
    }
}