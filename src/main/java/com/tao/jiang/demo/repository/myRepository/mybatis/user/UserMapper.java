package com.tao.jiang.demo.repository.myRepository.mybatis.user;

import com.tao.jiang.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface UserMapper {

    User findUserById(String string);

    User findUser(User user);

    User findByUserName(String userName);

    void save(User user);

    void updateLastLogin(String userId, Date lastLogin);

}