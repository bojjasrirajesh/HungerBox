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
 * @since 06-02-2020
 */

@RestController
@RequestMapping("/items")
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class ItemsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
	
	 @Autowired 
	 ItemsService itemsService;
	 /**
		 * This method is will give the list of all items  
		 * 
		 * @return ItemResponseDto 
		 */
	 @GetMapping("/allItem") 
	 public ItemResponseDto getAllItems() { 
		 LOGGER.info(LibraryUtil.GET_ITEM_METHOD);
		 return itemsService.getAllItems();
	 }
	 /**
		 * This mehod is used to add the items by the vendor 
		 * @param itemRequestDto
		 * @return ItemResponseDto 
		 */
	 @PostMapping(value = "/addItem") 
	 public ItemResponseDto addItems(@RequestBody ItemRequestDto itemRequestDto) { 
		 LOGGER.info(LibraryUtil.ADD_ITEM_METHOD);
		 return itemsService.addItem(itemRequestDto);
	 }
	 /**
		 * This method is used to deleting  the item by providing input as itemId 
		 * @param itemId
		 * @return ItemResponseDto 
		 */
	 @DeleteMapping(value ="/deleteItem/{itemId}") 
	 public ItemResponseDto deleteItem(@PathVariable Long itemId) { 
		 LOGGER.info(LibraryUtil.DELETE_ITEM_METHOD);
		 return itemsService.deleteItems(itemId);
	 }
}
