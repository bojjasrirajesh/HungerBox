package com.hcl.ing.hungerbox.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.hungerbox.dto.VendorResponseDto;
import com.hcl.ing.hungerbox.service.VendorService;
import com.hcl.ing.hungerbox.util.LibraryUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VendorController.class);
	
	 @Autowired 
	 VendorService vendorService;
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @GetMapping(value = "/vendors") 
	 public VendorResponseDto getAllVendors() { 
		 LOGGER.info(LibraryUtil.GET_VENDOR_METHOD);
		 return vendorService.getAllVendorsByUserId();
	 }

}
