package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.entity.Cart;
import com.exception.ShopingCartException;
import com.service.ShopingCartService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



@SpringBootTest
public class ShopingCartServiceTest 
{
	
	@Autowired
	ShopingCartService service;
	
	/**
	 * Test method for {@link com.onlinefurniturestore.service.ShopingCartService #getCartById(int)}.
	 * @throws ShopingCartException 
	 */
	@Test
	void testGetCartById1() throws ShopingCartException
	{
		Cart cart = service.getCartById(1);
		assertEquals(1, cart.getOrderNum());
	}
	
	@Test
	void testGetCartById2()
	{
		try 
		{
			service.getCartById(1);
		}
		catch(ShopingCartException e)
		{
			assertEquals("cartId does not exist", e.getMessage());	
		}
	
	}

	
	/**
	 * Test method for {@link com.onlinefurniturestore.service.ShopingCartService #getAllCarts()}.
	 * @throws ShopingCartException 
	 */
	
	@Test
	void testGetAllCarts() throws ShopingCartException 
	{
		List<Cart> list = new ArrayList<>();
		Cart cart1 = service.getCartById(1);
        Cart cart2 = service.getCartById(2);
        list.add(cart1);
        list.add(cart2);
        assertNotNull(list);
	}
	

	/**
	 * Test method for {@link com.onlinefurniturestore.service.ShopingCartService #deleteCartById(int)}.
	 */
	@Test
	void testDeleteCartById1()
	{
		try {
			service.deleteCartById(2);
		}
		catch (ShopingCartException e)
		{
			assertEquals("Cart does not exist", e.getMessage());
		}
	}
	
	@Test
	void testDeleteCartById2() throws ShopingCartException
	{
		assertEquals(service.getCartById(2).getOrderNum(), service.deleteCartById(2).getOrderNum());
	}

}
