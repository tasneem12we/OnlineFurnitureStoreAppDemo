package com.service;

import java.util.List;

import com.entity.Cart;
import com.exception.ShopingCartException;

public interface IShopingCartService {
	
	List<Cart> getAllCarts() throws ShopingCartException;
	Cart getCartById(int cartId) throws ShopingCartException;
	Cart updateCartById(int cartId,Cart cart) throws ShopingCartException;
	String deleteCart() throws ShopingCartException;
	Cart deleteCartById(int cartId) throws ShopingCartException;

}
