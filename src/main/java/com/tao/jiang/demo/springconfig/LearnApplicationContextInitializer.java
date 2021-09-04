package com.tao.jiang.demo.springconfig;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class LearnApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("容器中初始化bean的数量： " + configurableApplicationContext.getBeanDefinitionCount());
        for(String s : configurableApplicationContext.getBeanDefinitionNames()){
            System.out.println(s);
        }
    }
}
