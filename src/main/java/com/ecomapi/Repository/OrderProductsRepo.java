package com.ecomapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomapi.entities.OrderProducts;

public interface OrderProductsRepo extends CrudRepository<OrderProducts,Integer>{

}
