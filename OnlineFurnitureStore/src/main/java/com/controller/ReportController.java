package com.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;
import com.service.IReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

	@Autowired
	IReportService reportService;
	
	//To fetch all Bills details from the database
	@GetMapping(path = "/getAllBills")
	public ResponseEntity<List<Bill>> getBills() throws ReportException{
		return new ResponseEntity<>(reportService.getAllBills(), HttpStatus.OK);
	}
	
	//To fetch all customers details from the database
	@GetMapping(path = "/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws ReportException{
		return new ResponseEntity<>(reportService.getAllCustomers(), HttpStatus.OK);
	}
	
	//To fetch all Cart details from the database
	@GetMapping(path = "/getAllCartDetails")
	public ResponseEntity<List<Cart>> getAllCarts() throws ReportException{
		return new ResponseEntity<>(reportService.getAllCarts(), HttpStatus.OK);
	}
	
	//To fetch all Order details from the database
	@GetMapping(path = "/getAllOrderDetails")
	public ResponseEntity<List<FurnitureOrder>> getAllOrders() throws ReportException{
		return new ResponseEntity<>(reportService.getAllOrders(), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	

}
