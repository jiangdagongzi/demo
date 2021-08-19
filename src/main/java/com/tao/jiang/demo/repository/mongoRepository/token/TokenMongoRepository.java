package com.tao.jiang.demo.repository.mongoRepository.token;

import com.tao.jiang.demo.entity.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TokenMongoRepository extends MongoRepository<Token, String> {
    @Query("{'token':?0}")
    Token findByToken(String token);

}
