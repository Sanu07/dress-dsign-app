package com.fashion.query.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.fashion.dto.User;

@Repository
public interface UserQueryDao extends ReactiveMongoRepository<User, String>{

}
