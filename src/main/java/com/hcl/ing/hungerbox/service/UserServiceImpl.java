package com.hcl.ing.hungerbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.UserResponseDto;
import com.hcl.ing.hungerbox.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	
	
	@Override
	public UserResponseDto getAllVendors() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
