package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureOrder;
import com.exception.UserNotFoundException;
import com.repository.OrderRepository;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	OrderRepository od;
	
	// To fetch all FurnitureOrder details from the database 
	public List<FurnitureOrder> getAllOrders() {
		List<FurnitureOrder> getFurniture = od.findAll();
		return getFurniture;
	}

	//To update FurnitureOrde details to the database
	public FurnitureOrder updateOrder(FurnitureOrder order) throws UserNotFoundException
	{
		if ((order != null)) 
		{
			FurnitureOrder updateUser = od.save(order);
			return updateUser;
		} 
		else 
		{
			throw new UserNotFoundException("Order no exist");
		}
	}

	//To update FurnitureOrde by Id details to the database

	public FurnitureOrder updateOrderById(String orderId, FurnitureOrder order) throws UserNotFoundException 
	{
		FurnitureOrder resultUser;
		try 
		{
			order = od.findById(orderId).orElse(null);
			if (orderId.equals(order.getOrderId()))
			{
				resultUser = od.save(order);
				return resultUser;
			}
			else
			{
				throw new UserNotFoundException("No order found");
			}
		} 
		catch (Exception e) 
		{
			throw new UserNotFoundException("no orderFound");
		}
	}
	
}
