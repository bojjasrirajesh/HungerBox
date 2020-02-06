package com.hcl.ing.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.dto.UserResponseDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.repository.ItemRepository;
import com.hcl.ing.hungerbox.repository.UserRepository;
import com.hcl.ing.hungerbox.repository.VendorRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	
	
	@Override
	public UserResponseDto getAllVendors() {
		List<Vendors> findAll = vendorRepository.findAll();
		UserResponseDto userResponseDto=new UserResponseDto();
		userResponseDto.setMessage("success");
		userResponseDto.setStatusCode(200);
		userResponseDto.setVendors(findAll);
		
		return userResponseDto;
	}

	@Override
	public ItemResponseDto getItems(Long vendorId) {

		List<Items> findByVendorId = itemRepository.findByVendorId(vendorId);
		ItemResponseDto itemResponseDto=new ItemResponseDto();
		itemResponseDto.setMessage("success");
		itemResponseDto.setStatusCode(200);
		itemResponseDto.setItems(findByVendorId);
		
		return itemResponseDto;
	}

}
