package com.hcl.ing.hungerbox.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.hungerbox.dto.VendorRequestDto;
import com.hcl.ing.hungerbox.dto.VendorResponseDto;
import com.hcl.ing.hungerbox.service.VendorService;
import com.hcl.ing.hungerbox.util.LibraryUtil;

/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 30-01-2020
 */

@RestController
@RequestMapping("/vendor")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class VendorController {
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
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @PostMapping(value = "/addVendor") 
	 public VendorResponseDto addVendors(@RequestBody VendorRequestDto vendorRequestDto) { 
		 LOGGER.info(LibraryUtil.ADD_VENDOR_METHOD);
		 return vendorService.addVenders(vendorRequestDto);
	 }
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @DeleteMapping(value ="/deleteVendor/{vendorId}") 
	 public VendorResponseDto deleteVendor(@PathVariable Long vendorId) { 
		 LOGGER.info(LibraryUtil.DELETE_VENDOR_METHOD);
		 return vendorService.deleteVendor(vendorId);
	 }
}
