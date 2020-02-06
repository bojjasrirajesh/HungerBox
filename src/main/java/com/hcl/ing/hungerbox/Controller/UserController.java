package com.hcl.ing.hungerbox.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.dto.UserResponseDto;
import com.hcl.ing.hungerbox.service.UserService;
import com.hcl.ing.hungerbox.util.LibraryUtil;
/**
* 
* @author bojja.r
* @version 1.0
* @since 06-02-2020
*/
@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VendorController.class);
	
	 @Autowired 
	 UserService userService;
	 /**
		 * This method is used to get list of all vendors 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @GetMapping(value = "/vendors") 
	 public UserResponseDto getAllVendors() { 
		 LOGGER.info(LibraryUtil.GET_USER_ALl_VENDOR_METHOD);
		 return userService.getAllVendors();
	 }
	 /**
		 * This method is used to get list items  by vendor 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @GetMapping(value = "/getItems/{vendorId}") 
	 public ItemResponseDto getItems(@PathVariable Long vendorId) { 
		 LOGGER.info(LibraryUtil.ADD_ISER_ITEM_METHOD);
		 return userService.getItems(vendorId);
	 }
	 

}
