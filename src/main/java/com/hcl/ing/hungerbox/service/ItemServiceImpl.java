package com.hcl.ing.hungerbox.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.ItemRequestDto;
import com.hcl.ing.hungerbox.dto.ItemResponseDto;
import com.hcl.ing.hungerbox.dto.VendorRequestDto;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.entity.Vendors;
import com.hcl.ing.hungerbox.exception.AddItemException;
import com.hcl.ing.hungerbox.exception.DeleteItemException;
import com.hcl.ing.hungerbox.exception.NoItemsArePresentException;
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
		if(items.isEmpty()) {
			throw new NoItemsArePresentException("vendors are not available");
		}
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
		VendorRequestDto vendorRequestDto=new VendorRequestDto();
		vendorRequestDto.setUserId(itemRequestDto.getUserId());
		Vendors vendors=new Vendors(); 
		
		BeanUtils.copyProperties(vendorRequestDto, vendors);
		Vendors vendorRes = vendorRepository.save(vendors);
		items.setVendorId(vendorRes.getVendorId());
		itemRepository.save(items);
		List<Items> itemsSave = itemRepository.findAll();
		itemResponseDto.setMessage("success");
		itemResponseDto.setStatusCode(HttpStatus.OK.value());
		itemResponseDto.setItems(itemsSave);
		return itemResponseDto;
	}

	@Override
	public ItemResponseDto deleteItems(Long itemId) {
		List<Items> listOfItems = itemRepository.findAll();
		if(Objects.isNull(itemId)){
			throw new DeleteItemException("please provide the valid item id");
		}
		listOfItems.stream().forEach(listOfItem -> {
			if((listOfItem.getItemId().toString()).equals(itemId)) {
				itemRepository.deleteById(itemId);
				itemRepository.findAll();
				itemResponseDto.setMessage("success");
				itemResponseDto.setStatusCode(HttpStatus.OK.value());
				itemResponseDto.setItems(itemRepository.findAll());
			}
		});
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
