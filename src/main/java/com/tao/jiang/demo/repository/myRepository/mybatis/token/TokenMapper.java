package com.tao.jiang.demo.repository.myRepository.mybatis.token;

import com.tao.jiang.demo.entity.Token;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TokenMapper {
    //    public Token findTokenByUser();
    Token findTokenByTokenString(String token);

    Token findTokenByUserId(String userId);

    Token save(Token token);
}
