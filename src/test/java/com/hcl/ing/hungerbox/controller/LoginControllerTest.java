package com.hcl.ing.hungerbox.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.hungerbox.Controller.LoginController;
import com.hcl.ing.hungerbox.dto.LoginDto;
import com.hcl.ing.hungerbox.dto.LoginResponseDto;
import com.hcl.ing.hungerbox.entity.Users;
import com.hcl.ing.hungerbox.service.LoginService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginControllerTest {
	@InjectMocks
	LoginController loginController;
	
	@Mock
	LoginService loginService;
	
	@Test
	public void testuserLogin() {
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Users users=new Users();
		users.setUserName("rajesh");
		users.setPassword("rajesh123");
		users.setRoleName("Admin");
		users.setUserId(1L);
		
		LoginDto loginDto=new LoginDto();
		loginDto.setuName(users.getUserName());
		loginDto.setPassword(users.getPassword());
		loginDto.setRoleName(users.getRoleName());
		
		loginResponseDto.setMessage("success");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1L);
		loginResponseDto.setRoleName("Admin");
		
		
		Mockito.when(loginService.usersLogin(loginDto)).thenReturn(loginResponseDto);
		
		LoginResponseDto usersLogin = loginController.usersLogin(loginDto);
		Assert.assertNotNull(usersLogin);
		Assert.assertEquals(usersLogin.getRoleName(), "Admin");
	}
}
