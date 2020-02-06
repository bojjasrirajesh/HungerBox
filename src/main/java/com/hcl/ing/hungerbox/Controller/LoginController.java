package com.hcl.ing.hungerbox.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.hungerbox.dto.LoginDto;
import com.hcl.ing.hungerbox.dto.LoginResponseDto;
import com.hcl.ing.hungerbox.service.LoginService;
import com.hcl.ing.hungerbox.util.LibraryUtil;

/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 06-02-2020
 */

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	 @Autowired 
	 LoginService userService;
	 /**
		 * This method is used to login for the admin/vendor/user 
		 * @param loginDto
		 * @return LoginResponseDto 
		 */
	 @PostMapping(value = "/login") 
	 public LoginResponseDto usersLogin(@RequestBody LoginDto loginDto) { 
		 LOGGER.info(LibraryUtil.LOGIN_METHOD);
		 return userService.usersLogin(loginDto);
	 }
	 

}
