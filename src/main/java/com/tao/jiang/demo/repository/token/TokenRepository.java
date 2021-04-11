package com.tao.jiang.demo.repository.token;

import com.tao.jiang.demo.entity.Token;
import org.springframework.data.mongodb.repository.Query;

public interface TokenRepository {
    @Query("{'token':?0}")
    Token findByToken(String token);

    @Query()
    boolean createToken(Token token);
}
