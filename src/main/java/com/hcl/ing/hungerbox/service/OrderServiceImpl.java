package com.hcl.ing.hungerbox.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.hungerbox.dto.ItemDTO;
import com.hcl.ing.hungerbox.dto.OrderRequestDTO;
import com.hcl.ing.hungerbox.dto.OrderResponseDTO;
import com.hcl.ing.hungerbox.dto.ViewOrderResponseDTO;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.entity.OrderDetails;
import com.hcl.ing.hungerbox.entity.Orders;
import com.hcl.ing.hungerbox.exception.DataNotFoundException;
import com.hcl.ing.hungerbox.repository.ItemRepository;
import com.hcl.ing.hungerbox.repository.OrderDetailsRepository;
import com.hcl.ing.hungerbox.repository.OrderRepository;
import com.hcl.ing.hungerbox.util.HungerUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Override
	public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {

		
		
		Orders order = new Orders();
		order.setOrderDate(LocalDate.now().toString());
		order.setUserId(orderRequestDTO.getUserId());
		order = orderRepository.save(order);
		for (Items item : orderRequestDTO.getItems()) {
			
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setItemId(item.getItemId());
			orderDetails.setOrderDate(LocalDate.now().toString());
			orderDetails.setQuantity(item.getQuantity());
			orderDetails.setPrice(item.getPrice());
			orderDetails.setTotalPrice(item.getQuantity() * item.getPrice());
			orderDetails.setOrderId(order.getOrderId());
			orderDetails.setUserId(orderRequestDTO.getUserId());
			orderDetails.setVendorId(orderRequestDTO.getVendorId());
			orderDetails.setItemName(item.getItemName());
			orderDetailsRepository.save(orderDetails);
		}
		OrderResponseDTO orderResponseDTO = new OrderResponseDTO();

		orderResponseDTO.setStatus(order.getStatus());
		orderResponseDTO.setOrderId(order.getOrderId());
		return orderResponseDTO;
	}

	@Override
	public ViewOrderResponseDTO viewOrder(Long OrderId) {
		
		ViewOrderResponseDTO viewOrderResponseDTO= new ViewOrderResponseDTO();
		List<ItemDTO> itemDTOs= new ArrayList<ItemDTO>();
	List<OrderDetails> ordersList=orderDetailsRepository.findByOrderId(OrderId);
	
	for(OrderDetails orderDetails:ordersList)
	{
		ItemDTO itemDTO =new ItemDTO();
		
		itemDTO.setItemName(orderDetails.getItemName());
		itemDTO.setPrice(orderDetails.getPrice());
		itemDTO.setQuantity(orderDetails.getQuantity());
		itemDTOs.add(itemDTO);	
		System.out.println("The Value is "+itemDTO.getItemName());
	}
Orders order=orderRepository.findByOrderId(OrderId);
System.out.println("The Order Repository "+order.getOrderDate());
	viewOrderResponseDTO.setItemLists(itemDTOs);
	viewOrderResponseDTO.setOrderDate(order.getOrderDate());
	double amount=orderRepository.getTotalAmount(OrderId);
	System.out.println("The amount is  "+amount);
	viewOrderResponseDTO.setTotalPrice(amount);
	viewOrderResponseDTO.setOrderId(OrderId);
		
	
		return viewOrderResponseDTO;
	}

}
