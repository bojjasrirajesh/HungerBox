package com.hcl.ing.hungerbox.service;

import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.dto.UserResponseDto;

public interface UserService {
	
	UserResponseDto getAllVendors();
	ItemResponseDto getItems(Long vendorId);

}
