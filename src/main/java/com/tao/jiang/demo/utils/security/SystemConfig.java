package com.tao.jiang.demo.utils.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class SystemConfig extends WebMvcConfigurationSupport {

    @Value("${demo.static.dir}")
    private String staticDir;

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/*/*").
                excludePathPatterns("/demo/user/login", "/demo/user/register", "/demo/hello", "/demo/login.html", "/demo/register.html");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET","POST", "PUT","DELETE").allowedOrigins("*").allowedHeaders("*");
            }
        };
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        String os = System.getProperty("os.name");

        //如果是Windows系统
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/demo/**")
                    // /app_file/**表示在磁盘filePathWindow目录下的所有资源会被解析为以下的路径
                    .addResourceLocations("file:" + staticDir);
//
        }
    }

}