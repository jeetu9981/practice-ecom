package com.ecomapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomapi.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{

}
