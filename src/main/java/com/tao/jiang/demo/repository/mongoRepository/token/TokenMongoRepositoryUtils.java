package com.tao.jiang.demo.repository.mongoRepository.token;

import com.tao.jiang.demo.entity.Token;
import org.springframework.stereotype.Repository;

@Repository
public class TokenMongoRepositoryUtils {

    public Token findByToken(String token) {
        return null;
    }

    public boolean createToken(Token token) {
        return false;
    }
}
