package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.User;

@Repository
public interface LoginRegistrationDao extends CrudRepository<User, Long> {
	User findByLoginId(String userName);
}
