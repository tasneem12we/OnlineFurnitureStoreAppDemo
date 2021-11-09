package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;
import com.repository.OrderCancellationRepository;

@Service
public class OrderCancellationService implements IOrderCancellationService{
	
	@Autowired
	OrderCancellationRepository orderRepo;

	//To delete all FurnitureOrder from the database
	public String deleteOrder() throws OrderServiceException 
	{
		List<FurnitureOrder> resultFurniture;
		try
		{
			resultFurniture = orderRepo.findAll();
			if (resultFurniture != null) 
			{
				orderRepo.deleteAll();
				return "All Values are deleted successfully";
			} 
			else 
			{
				throw new OrderServiceException("There is no value in the furniture");
			}
		} 
		catch (Exception e) 
		{
			throw new OrderServiceException("There is no value in the furniture");
		}

	}

	//To delete Order by Id from the database
	public FurnitureOrder deleteOrderById(String orderId) throws OrderServiceException 
	{
		try 
		{
			FurnitureOrder del = orderRepo.findById(orderId).orElse(null);
			if (del == null) 
			{
				throw new OrderServiceException("no user found");
			} 
			else 
			{
				orderRepo.deleteById(orderId);
				return del;
			}
		} 
		catch (Exception e) 
		{
			throw new OrderServiceException("No order found");
		}
	}

	
	
}
