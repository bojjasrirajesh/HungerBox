package com.hcl.ing.hungerbox.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.dto.UserResponseDto;
import com.hcl.ing.hungerbox.dto.VendorResponseDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.repository.ItemRepository;
import com.hcl.ing.hungerbox.repository.UserRepository;
import com.hcl.ing.hungerbox.repository.VendorRepository;
import com.hcl.ing.hungerbox.service.UserServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	VendorRepository vendorRepository;
	
	@Mock
	ItemRepository itemRepository;
	
	@Test
	public void testGetAllVendors() {
		List<Vendors> vendors=new ArrayList<>();
		Vendors vendor=new Vendors();
		vendor.setUserId(1L);
		vendor.setVendorName("chinease");
		vendor.setVendorId(1L);
		vendor.setUserId(1L);
		vendors.add(vendor);
		
		Mockito.when(vendorRepository.findAll()).thenReturn(vendors);
		UserResponseDto allVendors = userServiceImpl.getAllVendors();
		
		assertEquals(allVendors.getStatusCode(),200);
	}
	@Test
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
		
		Mockito.when(itemRepository.findAll()).thenReturn(items);
		ItemResponseDto allItems = userServiceImpl.getItems(1L);
		
		Assert.assertEquals(allItems.getStatusCode().intValue(), 200);
	}

}
