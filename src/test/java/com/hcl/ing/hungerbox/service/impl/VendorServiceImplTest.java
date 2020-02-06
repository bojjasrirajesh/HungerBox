package com.hcl.ing.hungerbox.service.impl;

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

import com.hcl.ing.hungerbox.dto.VendorRequestDto;
import com.hcl.ing.hungerbox.dto.VendorResponseDto;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.repository.VendorRepository;
import com.hcl.ing.hungerbox.service.VendorServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class VendorServiceImplTest {
	@InjectMocks
	VendorServiceImpl vendorServiceImpl;
	
	@Mock
	VendorRepository vendorRepository;
	
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
		VendorResponseDto allVendors = vendorServiceImpl.getAllVendors();
		
		assertEquals(allVendors.getStatusCode(),200);
	
	}
	@Test
	public void testAddVenders() {
		
		Vendors vendor=new Vendors();
		vendor.setUserId(1L);
		vendor.setVendorName("orkjbfd");
		vendor.setVendorId(1L);
		Mockito.when(vendorRepository.save(vendor)).thenReturn(vendor);
		
		VendorRequestDto vendorRequestDto=new VendorRequestDto();
		vendorRequestDto.setVendorName("orkjbfd");
		vendorRequestDto.setUserId(1L);
		VendorResponseDto addVenders = vendorServiceImpl.addVenders(vendorRequestDto);
		
		Assert.assertEquals(addVenders.getStatusCode().intValue(), 201);
	
	}
	@Test
	public void testDeleteVendors() {
		
		Long vendorId=1L;
		vendorRepository.deleteById(vendorId);
		vendorServiceImpl.deleteVendor(vendorId);
		verify(vendorRepository, times(1)).deleteById(eq(vendorId));
	
	}
	private Long eq(Long vendorId) {
		return vendorId;
	}

}
