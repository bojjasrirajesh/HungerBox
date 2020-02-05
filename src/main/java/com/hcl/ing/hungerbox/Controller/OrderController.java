package com.hcl.ing.hungerbox.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.hungerbox.dto.OrderRequestDTO;
import com.hcl.ing.hungerbox.dto.OrderResponseDTO;
import com.hcl.ing.hungerbox.dto.ViewOrderResponseDTO;
import com.hcl.ing.hungerbox.entity.Items;
import com.hcl.ing.hungerbox.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<OrderResponseDTO> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO)
	{
		OrderRequestDTO orderRequestDTO1= new OrderRequestDTO();
		orderRequestDTO1.setOrderDate(LocalDate.now().toString());
		orderRequestDTO1.setUserId(1L);
		orderRequestDTO1.setVendorId(2L);
		
		Items items= new Items();
		Items items2= new Items();
		Items items3= new Items();

		List<Items> itemsList= new ArrayList<Items>();
		items.setItemId(1L);
		items.setItemName("Dosa");
		items.setItemType("lightFood");
		items.setPrice(20d);
		items.setQuantity(2);
		items.setUserId(1L);
		
		items2.setItemId(2L);
		items2.setItemName("Boori");
		items2.setItemType("NormalFood");
		items2.setPrice(30d);
		items2.setQuantity(3);
		items2.setUserId(1L);
		
		items3.setItemId(3L);
		items3.setItemName("Briyani");
		items3.setItemType("HeavyFood");
		items3.setPrice(80d);
		items3.setQuantity(2);
		items3.setUserId(1L);
		itemsList.add(items);
		itemsList.add(items2);
		itemsList.add(items3);
		orderRequestDTO1.setItems(itemsList);
		
		OrderResponseDTO orderResponseDTO= orderService.placeOrder(orderRequestDTO);
		return new ResponseEntity<>(orderResponseDTO,HttpStatus.OK) ;
		
	}
	
	@GetMapping("/viewController/{id}")
	public ResponseEntity<ViewOrderResponseDTO> viewOrder(@PathVariable("id") Long orderId ){
		ViewOrderResponseDTO viewOrderResponseDTO =	orderService.viewOrder(orderId);	
		return new ResponseEntity<>(viewOrderResponseDTO,HttpStatus.OK);
	}

}
