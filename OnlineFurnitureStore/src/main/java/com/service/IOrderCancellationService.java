package com.service;

import com.entity.Furniture;

import com.entity.FurnitureOrder;
import com.exception.OrderServiceException;

public interface IOrderCancellationService {
	
	String deleteOrder() throws OrderServiceException;
	FurnitureOrder deleteOrderById(String orderId)throws OrderServiceException;

}
