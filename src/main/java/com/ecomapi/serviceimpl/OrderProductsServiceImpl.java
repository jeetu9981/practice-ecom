package com.ecomapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.Repository.OrderProductsRepo;
import com.ecomapi.entities.OrderProducts;
import com.ecomapi.service.OrderProductsService;


@Service
public class OrderProductsServiceImpl implements OrderProductsService{

	@Autowired
	private OrderProductsRepo orderProductsRepo;
	
	@Override
	public boolean addOrderProducts(List<OrderProducts> op) {
		this.orderProductsRepo.saveAll(op);
		return true;
	}

}
