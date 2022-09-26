package com.ecomapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomapi.entities.Order;
import com.ecomapi.entities.User;

public interface OrderRepo extends CrudRepository<Order,Integer>{
	public Order findByUser(User userId);
}
