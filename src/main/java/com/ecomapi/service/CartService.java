package com.ecomapi.service;

import com.ecomapi.dto.CartDto;

public interface CartService {
	public boolean addCart(int userId,int productId);
	
	public boolean deleteCart(int cartId);
	
	public CartDto getMyCart(int userId);
	
	public boolean deleteAllCart(int userId);
}
