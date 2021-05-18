package com.fashion.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fashion.command.dao.UserCommandDao;
import com.fashion.entity.User;

@Service
public class JWTDBUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserCommandDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

		User user = userDao.findByLoginId(loginId);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + loginId);
		}
		return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getPassword(),
				new ArrayList<>());
	}

	public User save(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}

}