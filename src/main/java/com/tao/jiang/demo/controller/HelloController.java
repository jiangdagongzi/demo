package com.tao.jiang.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/${demo.stage.name}/demo")
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
      return "hello";
    }
}
