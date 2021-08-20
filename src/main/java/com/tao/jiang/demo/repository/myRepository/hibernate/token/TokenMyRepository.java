package com.tao.jiang.demo.repository.myRepository.hibernate.token;

import com.tao.jiang.demo.entity.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenMyRepository extends CrudRepository<Token, String> {

    Optional<Token> findById(String id);
}
