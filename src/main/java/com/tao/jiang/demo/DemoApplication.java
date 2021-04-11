package com.tao.jiang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    //解决no session
//    @Bean
//    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
//        return new OpenEntityManagerInViewFilter();
//    }
}
