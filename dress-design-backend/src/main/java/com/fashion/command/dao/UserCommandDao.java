package com.fashion.command.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.entity.User;

@Repository
public interface UserCommandDao extends JpaRepository<User, UUID> {
	User findByLoginId(String userName);
}
