package com.ecomapi.service;

import java.util.List;

import com.ecomapi.entities.OrderProducts;

public interface OrderProductsService {
	public boolean addOrderProducts(List<OrderProducts> op);
}
