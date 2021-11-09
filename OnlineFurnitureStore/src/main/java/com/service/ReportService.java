package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.FurnitureOrder;
import com.exception.ReportException;
import com.repository.BillRepository;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import com.repository.ShopingCartRepository;

@Service
public class ReportService implements IReportService{
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ShopingCartRepository cartRepository;
	
	//To fetch all Bills details from the database 
	public List<Bill> getAllBills() throws ReportException
	{
		List<Bill> bills = billRepository.findAll();
		return bills;
	}
	
	//To fetch all Customers details from the database
	public List<Customer> getAllCustomers() throws ReportException{
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}
	
	//To fetch all Cart details from the database 
	public List<Cart> getAllCarts() throws ReportException{
		List<Cart> carts = cartRepository.findAll();
		return carts;
	}
	
	//To fetch all Order details from the database 
	public List<FurnitureOrder> getAllOrders() throws ReportException{
		List<FurnitureOrder> orders = orderRepository.findAll();
		return orders;
	}
	
	

}
