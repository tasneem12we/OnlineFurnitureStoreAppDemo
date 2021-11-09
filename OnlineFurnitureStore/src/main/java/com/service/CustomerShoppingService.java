package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;
import com.repository.CustomerRepository;
import com.repository.FurnitureRepository;
import com.repository.OrderRepository;
import com.repository.ShopingCartRepository;

@Service
public class  CustomerShoppingService implements ICustomerShoppingService{
	
	@Autowired
	FurnitureRepository furnitureRepo;
	@Autowired
	ShopingCartRepository cartRepo;
	@Autowired
	public OrderRepository orderRepo;
	@Autowired
    public CustomerRepository cup;
	
	
	
	//To fetch all Furniture details from the database 
	@Transactional
	public List<Furniture> getAllFurnitures() throws CustomerShoppingException{
		try {
		List<Furniture> resultFurniture = furnitureRepo.findAll();
		if(resultFurniture!=null) {
		return resultFurniture;
		}
		else {
			throw new CustomerShoppingException("The Furniture is empty");
		}
		}
		catch(Exception e) {
			throw new CustomerShoppingException("The Furniture is empty");
		}
	}
	
	//add customer details
	@Transactional
	public Customer addCustomerDetails(Customer cd) {
		return cup.save(cd);
		}
	
	// To fetch Furniture by name details from the database 
	@Transactional
	public Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException {

		try {
			Furniture result = furnitureRepo.findbyName(furnitureName);
				return result; 
		}
		catch (Exception e) {
			throw new CustomerShoppingException("Furniture not found");
		}
	}

	//To add Cart to the database 
	@Transactional
	public Cart addtoCart(Cart furniture) throws CustomerShoppingException {

		if ((furniture.getCartId()!= 0)) {
			Cart updateUser = cartRepo.save(furniture);
			return updateUser;

		} else {
			throw new CustomerShoppingException("Furniture not added to cart");

		}
	}
	
	//To add FurnitureOrder to the database 
	@Transactional
	public FurnitureOrder placeOrder(FurnitureOrder order) throws CustomerShoppingException {
		if ((order.getOrderId()!=null)) {
			FurnitureOrder placeOrder = orderRepo.save(order);
			return placeOrder;

		} else {
			throw new CustomerShoppingException("Order cannot be placed");

		}
	}
	
}
