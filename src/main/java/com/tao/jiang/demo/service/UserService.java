package com.tao.jiang.demo.service;

import com.tao.jiang.demo.entity.User;
import com.tao.jiang.demo.repository.mongoRepository.user.UserMongoRepository;
import com.tao.jiang.demo.repository.myRepository.mybatis.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String userName) {
        return userMapper.findByUserName(userName);
    }

    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    public void save(User user) {
        userMapper.save(user);
    }

    public void updateLastLogin(String userId, Date lastLogin){
        userMapper.updateLastLogin(userId, lastLogin);
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
