package com.ecomapi.service;

import com.ecomapi.dto.OrderDto;
import com.ecomapi.entities.Order;

public interface OrderService {
	public boolean addOrder(Order order);
	
	public OrderDto getOrders(int userId);
}
