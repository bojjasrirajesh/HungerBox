package com.hcl.ing.hungerbox.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.ItemRequestDto;
import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.exception.AddItemException;
import com.hcl.ing.hungerbox.exception.DeleteItemException;
import com.hcl.ing.hungerbox.repository.ItemRepository;
import com.hcl.ing.hungerbox.repository.VendorRepository;

@Service
public class ItemServiceImpl implements ItemsService{

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	VendorRepository vendorRepository;
	
	ItemResponseDto itemResponseDto=new ItemResponseDto();
	@Override
	public ItemResponseDto getAllItems() {
		List<Items> items = itemRepository.findAll();
		itemResponseDto.setMessage("success");
		itemResponseDto.setStatusCode(HttpStatus.OK.value());
		itemResponseDto.setItems(items);
		return itemResponseDto;
	}

	@Override
	public ItemResponseDto addItem(ItemRequestDto itemRequestDto) {
		String itemName = itemRequestDto.getItemName();
		if(Objects.isNull(itemName)) {
			throw new AddItemException("please provide valid itemName");
		}
		Items items=new Items();
		BeanUtils.copyProperties(itemRequestDto, items);
		
		itemRepository.save(items);
		itemResponseDto.setMessage("success");
		itemResponseDto.setStatusCode(HttpStatus.CREATED.value());
		return itemResponseDto;
	}

	@Override
	public ItemResponseDto deleteItems(Long itemId) {
		List<Items> items = itemRepository.findAll();
		for (Items item : items) {
			if(!(item.getItemId().equals(itemId))) {
				throw new DeleteItemException("please provide the valide vendor id");
			}else {
				itemRepository.deleteById(itemId);
				itemRepository.findAll();
				itemResponseDto.setMessage("success");
				itemResponseDto.setStatusCode(HttpStatus.OK.value());
				itemResponseDto.setItems(itemRepository.findAll());
			}
		}
		return itemResponseDto;
	}

	@Override
	public ItemResponseDto getAllItemsById(Long vendorId) {
		List<Items> findByVendorId = vendorRepository.findByVendorId(vendorId);
		itemResponseDto.setMessage("success");
		itemResponseDto.setStatusCode(200);
		itemResponseDto.setItems(findByVendorId);
		
		return itemResponseDto;
	}

}
