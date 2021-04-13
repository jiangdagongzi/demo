package com.tao.jiang.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tao.jiang.demo.entity.Token;
import com.tao.jiang.demo.entity.User;
import com.tao.jiang.demo.repository.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    public Token getToken(User user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;
        Date end = new Date(currentTime);
        String tokenString = "";

        try {
            tokenString = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                    .sign(Algorithm.HMAC256(user.getPassword()));
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
        tokenRepository.save(token);
    }
}