package com.tao.jiang.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.entity.User;
import com.tao.jiang.demo.repository.mongoRepository.token.TokenMongoRepository;
import com.tao.jiang.demo.utils.ConfigurationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TokenService {

    @Autowired
    TokenMongoRepository tokenMongoRepository;

    public Token getToken(User user) {
        Date start = new Date();
        String tokenString = "";
        try {
            tokenString = JWT.create().withAudience(user.getId())
                    .withIssuedAt(start)
                    .sign(Algorithm.HMAC256(user.getPassword() + ConfigurationManager.getInstance().getTokenSalt()));
        } catch (Exception e) {

        }
        Token token = new Token();
        token.setCreateTime(start);
        token.setToken(tokenString);
        token.setOwnerName(user.getUserName());
        token.setOwnerId(user.getId());
        return token;
    }

    public void save(Token token) {
        tokenMongoRepository.save(token);
    }
}