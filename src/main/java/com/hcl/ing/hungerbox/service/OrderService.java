package com.hcl.ing.hungerbox.service;

import com.hcl.ing.hungerbox.dto.OrderRequestDTO;
import com.hcl.ing.hungerbox.dto.OrderResponseDTO;
import com.hcl.ing.hungerbox.dto.ViewOrderResponseDTO;


public interface OrderService {

 public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);	
 public ViewOrderResponseDTO viewOrder(Long OrderId);
 
}
