package com.hcl.ing.hungerbox.service;

import com.hcl.ing.hungerbox.dto.LoginDto;
import com.hcl.ing.hungerbox.dto.LoginResponseDto;

public interface LoginService {
	
	 LoginResponseDto usersLogin(LoginDto userDto); 

}
