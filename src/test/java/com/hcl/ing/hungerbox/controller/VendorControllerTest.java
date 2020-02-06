package com.hcl.ing.hungerbox.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
import com.hcl.ing.hungerbox.Controller.VendorController;
import com.hcl.ing.hungerbox.dto.VendorRequestDto;
import com.hcl.ing.hungerbox.dto.VendorResponseDto;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.service.LoginService;
import com.hcl.ing.hungerbox.service.VendorService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VendorControllerTest {
	@InjectMocks
	VendorController vendorController;
	
	@Mock
	VendorService vendorService;
	
	@Test
	public void testGetAllVendors() {
		List<Vendors> vendors=new ArrayList<>();
		Vendors vendor=new Vendors();
		vendor.setUserId(1L);
		vendor.setVendorName("chinease");
		vendor.setVendorId(1L);
		vendor.setUserId(1L);
		vendors.add(vendor);
		VendorResponseDto vendorResponseDto=new VendorResponseDto();
		BeanUtils.copyProperties(vendor, vendorResponseDto);
		Mockito.when(vendorService.getAllVendors()).thenReturn(vendorResponseDto);
		VendorResponseDto allVendors = vendorController.getAllVendors();
		
		Assert.assertNotNull(allVendors);
	}
	/*@Test
	public void testAddVendors() {
		Vendors vendor=new Vendors();
		vendor.setUserId(1L);
		vendor.setVendorName("orkjbfd");
		vendor.setVendorId(1L);
		VendorRequestDto vendorRequestDto=new VendorRequestDto();
		BeanUtils.copyProperties(vendor, vendorRequestDto);
		VendorResponseDto vendorResponseDto=new VendorResponseDto();
		Mockito.when(vendorService.addVenders(vendorRequestDto)).thenReturn(vendorResponseDto);
		
		VendorRequestDto vendorRequestDto1=new VendorRequestDto();
		vendorRequestDto1.setVendorName("orkjbfd");
		vendorRequestDto1.setUserId(1L);
		VendorResponseDto addVenders = vendorController.addVendors(vendorRequestDto1);
		
		Assert.assertEquals(addVenders.getStatusCode().intValue(), 201);
	}*/
	/*@Test
	public void testDeleteVendor() {
		Long vendorId=1L;
		vendorService.deleteVendor(vendorId);
		vendorController.deleteVendor(vendorId);
		verify(vendorService, times(1)).deleteVendor(eq(vendorId));
	
	}*/
	private Long eq(Long vendorId) {
		return vendorId;
	}

}
