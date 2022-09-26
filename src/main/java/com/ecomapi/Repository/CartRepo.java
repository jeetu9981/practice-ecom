package com.ecomapi.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomapi.entities.Cart;
import com.ecomapi.entities.User;

public interface CartRepo extends CrudRepository<Cart,Integer>{
	@Modifying
	@Query(value="delete from cart where user_user_id=:userId",nativeQuery = true)
	public int deleteByUserId(@RequestParam("userId") User userId);
}
