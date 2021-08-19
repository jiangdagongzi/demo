package com.tao.jiang.demo.repository.myRepository.user;

import com.tao.jiang.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMyRepository extends CrudRepository<User, String> {
    Optional<User> findById(String id);
}
