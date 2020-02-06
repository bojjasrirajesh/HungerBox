package com.hcl.ing.hungerbox.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.ing.hungerbox.Controller.LoginController;
import com.hcl.ing.hungerbox.Controller.UserController;
import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.dto.UserResponseDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.service.LoginService;
import com.hcl.ing.hungerbox.service.UserService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Test
	public void testGetAllVendors() {
		List<Vendors> vendors=new ArrayList<>();
		Vendors vendor=new Vendors();
		vendor.setUserId(1L);
		vendor.setVendorName("chinease");
		vendor.setVendorId(1L);
		vendor.setUserId(1L);
		vendors.add(vendor);
		
		UserResponseDto userResponseDto=new UserResponseDto();
		
		BeanUtils.copyProperties(vendors, userResponseDto);
		Mockito.when(userService.getAllVendors()).thenReturn(userResponseDto);
		UserResponseDto allVendors = userController.getAllVendors();
		Assert.assertNotNull(allVendors);
		
	}
	
	/*@Test
	public void testGetItems() {
		
		List<Items> items=new ArrayList<>();
		Items item=new Items();
		item.setItemId(1L);
		item.setItemName("dossa");
		item.setItemType("jbdf");
		item.setPrice(20d);
		item.setQuantity(2);
		item.setUserId(1L);
		item.setVendorId(1L);
		items.add(item);
		
		ItemResponseDto itemResponseDto=new ItemResponseDto();
		BeanUtils.copyProperties(items, itemResponseDto);
		Mockito.when(userService.getItems(item.getVendorId())).thenReturn(itemResponseDto);
		ItemResponseDto allItems = userController.getItems(1L);
		
		Assert.assertEquals(allItems.getStatusCode().intValue(), 200);
		
	}*/
	
}
