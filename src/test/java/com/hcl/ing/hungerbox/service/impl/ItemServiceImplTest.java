package com.hcl.ing.hungerbox.service.impl;

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

import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.repository.ItemRepository;
import com.hcl.ing.hungerbox.service.ItemServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ItemServiceImplTest {
	@InjectMocks
	ItemServiceImpl itemServiceImpl;
	
	@Mock
	ItemRepository itemRepository;
	
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
		
		Mockito.when(itemRepository.findAll()).thenReturn(items);
		ItemResponseDto allItems = itemServiceImpl.getAllItems();
		
		Assert.assertEquals(allItems.getStatusCode().intValue(), 200);
	
	}
	/*@Test
	public void testAddItem() {
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
		
		Mockito.when(itemRepository.save(item)).thenReturn(item);
		ItemRequestDto itemd=new ItemRequestDto();
		BeanUtils.copyProperties(item, itemd);
		ItemResponseDto addItem = itemServiceImpl.addItem(itemd);
		Assert.assertEquals(addItem.getStatusCode().intValue(), 200);
		
		
		}*/
	
	@Test
	public void testDeleteItems() {
		Long itemId=1L;
		itemRepository.deleteById(itemId);
		itemServiceImpl.deleteItems(itemId);
		verify(itemRepository, times(1)).deleteById(eq(itemId));
	
	}
	private Long eq(Long vendorId) {
		return vendorId;
	}
		

}
