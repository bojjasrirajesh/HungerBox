package com.hcl.ing.hungerbox.service;

import com.hcl.ing.hungerbox.dto.ItemRequestDto;
import com.hcl.ing.hungerbox.dto.ItemResponseDto;

public interface ItemsService {
	ItemResponseDto getAllItems();
	ItemResponseDto getAllItemsById(Long vendorId);
	ItemResponseDto addItem(ItemRequestDto vendorRequestDto);
	ItemResponseDto deleteItems(Long itemId);

}
