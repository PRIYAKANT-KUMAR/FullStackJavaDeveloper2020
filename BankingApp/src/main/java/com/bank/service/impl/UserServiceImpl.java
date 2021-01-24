package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.UserDetail;
import com.bank.repo.UserRepository;
import com.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Integer registerUser(UserDetail userDetails) {

		UserDetail userDetail = userRepository.save(userDetails);

		return userDetail.getAccountDetail().getAccountNo();
	}

}
