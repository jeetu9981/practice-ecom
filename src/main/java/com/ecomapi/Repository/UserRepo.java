package com.ecomapi.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ecomapi.entities.User;

public interface UserRepo extends CrudRepository<User,Integer>{
	public User findByEmailAndPassword(String email,String password);
}
