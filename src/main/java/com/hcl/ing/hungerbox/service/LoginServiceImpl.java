package com.hcl.ing.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.LoginDto;
import com.hcl.ing.hungerbox.dto.LoginResponseDto;
import com.hcl.ing.hungerbox.entity.Users;
import com.hcl.ing.hungerbox.repository.LoginRepository;
import com.hcl.ing.hungerbox.util.LibraryUtil;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		List<Users> users = loginRepository.findAll();
		LoginResponseDto responseDto = new LoginResponseDto();

		for (Users user : users) {
			if ((userDto.getuName().equalsIgnoreCase(user.getUserName()))&& (user.getPassword().equals(userDto.getPassword()))&&(user.getRoleName().equals(userDto.getRoleName()))) {
				responseDto.setMessage(LibraryUtil.LOGIN_SUCCESS);
				responseDto.setStatusCode(HttpStatus.OK.value());
				responseDto.setRoleName(user.getRoleName());
				responseDto.setUserId(user.getUserId());
				return responseDto;
			}
		}
		responseDto.setMessage(LibraryUtil.INVALID_LOGIN);
		responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return responseDto;
	}


}
