package com.ecomapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomapi.entities.Category;

public interface CategoryRepo extends CrudRepository<Category,Integer>{
	
}
