package com.tao.jiang.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getUser(){
//
//    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String login(){
        return null;
    }
}
