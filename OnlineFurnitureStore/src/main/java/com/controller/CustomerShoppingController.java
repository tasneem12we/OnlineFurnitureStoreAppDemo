package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;
import com.service.ICustomerShoppingService;

@RestController
@RequestMapping("/api/ShowCustomerShopping")
public class CustomerShoppingController {
	
	@Autowired
	ICustomerShoppingService onlineFurnitureStoreService;
	
	//add customer details
	@PostMapping(path="/addCustomerdetails")
	public  ResponseEntity<Customer> addCustomerDetails(@RequestBody Customer customer) throws CustomerShoppingException {
		Customer c1 = onlineFurnitureStoreService.addCustomerDetails(customer);
		return new ResponseEntity<Customer>(c1, HttpStatus.OK);
	}

	
	//To get all Furniture from the database 
	@GetMapping(path = "/getAllFurnitureDetails")
	public ResponseEntity<List<Furniture>> getAllFurnitureDetails() throws CustomerShoppingException {
		List<Furniture> resultFurniture = onlineFurnitureStoreService.getAllFurnitures();
		return  new ResponseEntity<List<Furniture>>(resultFurniture, HttpStatus.OK);
	}
	
	//To get the Furniture by the given id from the database 
	@GetMapping(path = "/getFurnitureDetails/{furnitureName}")
	public ResponseEntity<Furniture> getFurniture(@PathVariable("furnitureName") String furnitureName) throws CustomerShoppingException {
		
		Furniture resultFurniture=onlineFurnitureStoreService.getFurnitureByName(furnitureName);
		return new ResponseEntity<Furniture>(resultFurniture, HttpStatus.OK);
	}
	
	//To add cart to the database 
	@PostMapping("/addCart")
	public String addFurniture(@RequestBody Cart cart) throws CustomerShoppingException {
		Cart furniture1 = onlineFurnitureStoreService.addtoCart(cart);
		return "furniture created" + furniture1;
	}
	
	
	//To add order to the database 
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody FurnitureOrder furnitureorder) throws CustomerShoppingException {
		FurnitureOrder furniture1 = onlineFurnitureStoreService.placeOrder(furnitureorder);
		return "order placed" + furniture1;

	}
	
	
	
	
	

}
