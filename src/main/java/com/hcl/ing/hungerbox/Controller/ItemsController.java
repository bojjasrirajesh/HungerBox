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

import com.hcl.ing.hungerbox.dto.ItemRequestDto;
import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.service.ItemsService;
import com.hcl.ing.hungerbox.util.LibraryUtil;

/**
 * 
 * @author bojja.r
 * @version 1.0
 * @since 30-01-2020
 */

@RestController
@RequestMapping("/items")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class ItemsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
	
	 @Autowired 
	 ItemsService itemsService;
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @GetMapping("/allItem") 
	 public ItemResponseDto getAllItems() { 
		 LOGGER.info(LibraryUtil.GET_ITEM_METHOD);
		 return itemsService.getAllItems();
	 }
	 @GetMapping("/allItem/{vendorId}") 
	 public ItemResponseDto getAllItemsById(@PathVariable Long vendorId) { 
		 LOGGER.info(LibraryUtil.GET_ITEM_METHOD);
		 return itemsService.getAllItemsById(vendorId);
	 }
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @PostMapping(value = "/addItem") 
	 public ItemResponseDto addItems(@RequestBody ItemRequestDto itemRequestDto) { 
		 LOGGER.info(LibraryUtil.ADD_ITEM_METHOD);
		 return itemsService.addItem(itemRequestDto);
	 }
	 /**
		 * This method is used to validating the user by providing the input as LoginDto 
		 * @param loginDto
		 * @return responseDTO 
		 */
	 @DeleteMapping(value ="/deleteItem/{itemId}") 
	 public ItemResponseDto deleteItem(@PathVariable Long idemID) { 
		 LOGGER.info(LibraryUtil.DELETE_ITEM_METHOD);
		 return itemsService.deleteItems(idemID);
	 }
}
