package com.tao.jiang.demo.repository.mongoRepository.user;

import com.tao.jiang.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String> {

    @Query("{'userName':?0}")
    User findByUsername(String userName);

    @Query("{'id':?0}")
    User findUserById(String id);
}
