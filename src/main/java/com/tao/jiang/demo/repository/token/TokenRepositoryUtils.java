package com.tao.jiang.demo.repository.token;

import com.tao.jiang.demo.entity.Token;
import org.springframework.stereotype.Repository;

@Repository
public class TokenRepositoryUtils implements TokenRepository{
    @Override
    public Token findByToken(String token) {
        return null;
    }

    @Override
    public boolean createToken(Token token) {
        return false;
    }
}
