package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;
import com.service.IOrderCancellationService;

@RestController
@RequestMapping("/api/showOrderCancellation")
public class OrderCancellationController {

	@Autowired
	IOrderCancellationService ordercancellation;
	
	//To delete order from the database 
	@DeleteMapping(path = "/deleteFurniture/{orderId}")
	public FurnitureOrder deleteFurnitureByID(@PathVariable("orderId") String orderId) throws OrderServiceException {

		return ordercancellation.deleteOrderById(orderId);
	}
	
	//To delete all order from the database
	@DeleteMapping(path = "/deleteOrder")
	public String deleteOrder() throws OrderServiceException {
		String order3 = ordercancellation.deleteOrder();
		return "Deletion Completed for" + order3;
	}

	
	
	
}