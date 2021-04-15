package com.tao.jiang.demo.controller;

import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.entity.User;
import com.tao.jiang.demo.repository.token.TokenRepository;
import com.tao.jiang.demo.service.TokenService;
import com.tao.jiang.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/${demo.stage.name}/user")
public class UserController {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpEntity<?> register(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password
    ) {
        User user = userService.findByUsername(userName);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exist!");
        } else {
            if (!UserService.userNameValid(userName)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Username not valid!");
            } else {
                if (!UserService.passwordValid(password)) {
                    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Password not valid!");
                } else {
                    User newUser = new User();
                    newUser.setUserName(userName);
                    newUser.setPassword(UserService.encryptPassword(password));
                    userService.save(newUser);
                    return ResponseEntity.status(HttpStatus.OK).body("User registered!");
                }
            }
        }

    }

    //    @ApiOperation(value = "登陆", notes = "登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpEntity<?> login(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password
    ) {
        User user = userService.findByUsername(userName);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist!");
        }
        if (!UserService.checkpassword(password, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong password!");
        } else {
            Token token = tokenService.getToken(user);
            tokenService.save(token);
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }
    }


    /***
     * 这个请求需要验证token才能访问
     *
     * @authur: tao
     * @return String 返回类型
     */
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public HttpEntity<?> getMessage(
            @RequestParam(value = "userName", required = true) String userName) {
        return ResponseEntity.status(HttpStatus.OK).body("Validation passed!");
    }

}
