package com.tao.jiang.demo.controller;

import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.repository.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private TokenRepository tokenRepository;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getUser(){
//
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(){
        return null;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(){
        return null;
    }

}
