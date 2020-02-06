package com.hcl.ing.hungerbox.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.hungerbox.dto.LoginDto;
import com.hcl.ing.hungerbox.dto.LoginResponseDto;
import com.hcl.ing.hungerbox.entity.Users;
import com.hcl.ing.hungerbox.repository.LoginRepository;
import com.hcl.ing.hungerbox.service.LoginServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	LoginRepository loginRepository;
	
	@Test
	public void testUsersLoginPossitive() {
		
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		List<Users> listUsers=new ArrayList<>();
		
		Users users=new Users();
		users.setUserName("rajesh");
		users.setPassword("rajesh123");
		users.setRoleName("Admin");
		users.setUserId(1L);
		listUsers.add(users);
		
		LoginDto loginDto=new LoginDto();
		loginDto.setuName(users.getUserName());
		loginDto.setPassword(users.getPassword());
		loginDto.setRoleName(users.getRoleName());
		
		loginResponseDto.setMessage("success");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1L);
		loginResponseDto.setRoleName("Admin");
		
		
		Mockito.when(loginRepository.findAll()).thenReturn(listUsers);
		
		LoginResponseDto usersLogin = loginServiceImpl.usersLogin(loginDto);
		Assert.assertNotNull(usersLogin);
		Assert.assertEquals(usersLogin.getRoleName(), "Admin");
	}

}
