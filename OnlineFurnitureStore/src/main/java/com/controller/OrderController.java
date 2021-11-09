package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.FurnitureOrder;
import com.exception.UserNotFoundException;
import com.service.IOrderService;

@RestController
@RequestMapping("/api/Order")
public class OrderController {

	@Autowired
	public IOrderService osi;
	
	//To update Order details to the database
	@PutMapping(path = "/updateOrder")
	public String updateOrder(@RequestBody FurnitureOrder order) throws UserNotFoundException {
		FurnitureOrder user1 = osi.updateOrder(order);
		return "User Updated Successfully" + user1;
	}
	
	//To update Order details to the database by Id
	@PutMapping(path = "/updateOrderById/{orderId}")
	public String updateOrderById(@RequestBody FurnitureOrder order) throws UserNotFoundException {
		FurnitureOrder user2 = osi.updateOrderById(order.getOrderId(), order);
		return "User Updated Successfully" + user2;
	}
	
	//To fetch all Order details from the database
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrderDetails() throws UserNotFoundException {

		List<FurnitureOrder> resultFurniture = osi.getAllOrders();
		return new ResponseEntity<List<FurnitureOrder>>(resultFurniture, HttpStatus.OK);
	}
	
	
}
