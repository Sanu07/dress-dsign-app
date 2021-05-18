package com.fashion.command.service;

import java.util.UUID;

import com.fashion.entity.User;

public interface UsersCommandService {

	public User saveUser(User user);

	public User updateUser(User user);

	public void deleteUser(UUID userId);

}
