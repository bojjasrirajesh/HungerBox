package com.hcl.ing.hungerbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.ing.hungerbox.Controller.ItemsController;
import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.repository.VendorRepository;
import com.hcl.ing.hungerbox.service.ItemsService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ItemsControllerTest {
	
	@InjectMocks
	ItemsController itemsController;
	
	@Mock
	ItemsService itemsService;
	@Mock
	VendorRepository vendorRepository;
	@Test
	public void testGetAllItems() {
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
		ItemResponseDto itemResponseDto=new ItemResponseDto();
		BeanUtils.copyProperties(items, itemResponseDto);
		Mockito.when(itemsService.getAllItems()).thenReturn(itemResponseDto);
		
		ItemResponseDto itemsResp = itemsController.getAllItems();
		Assert.assertNotNull(itemsResp);
	}
	
	/*@Test
	public void testGetAllItemsById() {
		
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
		
		ItemRequestDto itemRequestDto=new ItemRequestDto();
		BeanUtils.copyProperties(item, itemRequestDto);
		
		ItemResponseDto itemResponseDto=new ItemResponseDto();
		BeanUtils.copyProperties(item, itemResponseDto);
		
		Mockito.when(itemsService.getAllItemsById(item.getVendorId())).thenReturn(itemResponseDto);
		List<Items> findByVendorId = vendorRepository.findByVendorId(item.getVendorId());
		
		
		ItemResponseDto addItem = itemsController.addItems(itemRequestDto);
		
		Assert.assertEquals(addItem.getStatusCode().intValue(), 200);
		
		
		}*/
	/*@Test
	public void testdeleteItem() {
		Long itemId=1L;
		itemsService.deleteItems(itemId);
		itemsController.deleteItem(itemId);
		verify(itemsService, times(1)).deleteItems(eq(itemId));
	}*/
	private Long eq(Long vendorId) {
		return vendorId;
	}

}
