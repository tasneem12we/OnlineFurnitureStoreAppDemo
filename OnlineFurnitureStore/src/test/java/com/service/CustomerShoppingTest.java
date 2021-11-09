package com.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.entity.Address;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Furniture;
import com.entity.FurnitureOrder;
import com.exception.CustomerShoppingException;
import com.service.ICustomerShoppingService;

@SpringBootTest

public class CustomerShoppingTest {

	@Autowired
	ICustomerShoppingService service;

	@Test

	void testgetFurnitureByName() throws CustomerShoppingException {

		Furniture furniture = new Furniture();
		furniture.setFurnitureId(434);
		furniture.setFurnitureColor("blue");
		furniture.setFurnitureModel("swings");
		furniture.setFurnitureName("swings");
		furniture.setPrice(125.0);
		assertEquals("swings", service.getFurnitureByName("swings").getFurnitureName());

	}

	@Test
	void testAllFurniture() throws CustomerShoppingException {
		assertNotNull(service.getAllFurnitures());
	}

	@Test
	void addCart() throws CustomerShoppingException {
		Cart cart = new Cart();
		cart.setCartId(44);
		cart.setOrderNum(3533);
		cart.setQuantity(4);
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		cart.setFurniture(furniture);
		Customer customer = new Customer();
		customer.setName("angel");
		customer.setContactNo("9443204173");
		customer.setEmail("angel@gmail.com");
		//customer.setUId(5);
		//customer.setUsername("agnel");
		//customer.setPassword("angel");
		//customer.setRole("admin");
		Address address = new Address();
		address.setAddressId(11);
		address.setCity("KVP");
		address.setCountry("IN");
		address.setState("TN");
		address.setPincode("628501");
		customer.setAddress(address);
		cart.setCustomer(customer);
		assertEquals(cart.getQuantity(), service.addtoCart(cart).getQuantity());
	}

	@Test
	void testPlaceOrder() throws CustomerShoppingException {
		FurnitureOrder order = new FurnitureOrder();
		order.setAmount(456.90);
		order.setOrderId("13");
		order.setPrice(445.6);
		order.setQuanity(4);
		order.setStatus("pending");
		Furniture furniture = new Furniture();
		furniture.setFurnitureId(34);
		furniture.setFurnitureColor("Black");
		furniture.setFurnitureModel("Standard Bed Frame");
		furniture.setFurnitureName("Bed");
		order.setFurniture(furniture);
		Customer customer = new Customer();
		customer.setName("angel");
		customer.setContactNo("9443204173");
		customer.setEmail("angel@gmail.com");
	//	customer.setUId(5);
		//customer.setUsername("agnel");
		//customer.setPassword("angel");
		//customer.setRole("admin");
		Address address = new Address();
		address.setAddressId(11);
		address.setCity("KVP");
		address.setCountry("IN");
		address.setState("TN");
		address.setPincode("628501");
		customer.setAddress(address);
		order.setCustomer(customer);
		assertEquals(order.getQuanity(), service.placeOrder(order).getQuanity());
	}
}
