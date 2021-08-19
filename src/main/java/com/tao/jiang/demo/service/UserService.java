package com.tao.jiang.demo.service;

import com.tao.jiang.demo.entity.User;
import com.tao.jiang.demo.repository.mongoRepository.user.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

@Service
public class UserService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    public User findByUsername(String userName) {
        return userMongoRepository.findByUsername(userName);
    }

    public User findUserById(String userId) {
        return userMongoRepository.findUserById(userId);
    }

    public User save(User user) {
        return userMongoRepository.save(user);
    }

    public static boolean userNameValid(String userName) {
        String regExp = "^[^0-9][\\w_]{5,9}$";
        if (userName.matches(regExp)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean passwordValid(String password) {
        String regExp = "^[\\w_]{6,20}$";
        if (password.matches(regExp)) {
            return true;
        }
        return false;
    }

    public static String  encryptPassword(String pwd) {
        String newstr = null;
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();

            newstr = base64en.encode(md5.digest(pwd.getBytes("utf-8")));
        }catch (Exception e){

        }
        return newstr;
    }

    public static boolean checkpassword(String newpasswd,String oldpasswd) {
        if(encryptPassword(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}
