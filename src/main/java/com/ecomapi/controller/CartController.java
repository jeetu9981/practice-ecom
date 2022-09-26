package com.ecomapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.dto.CartDto;
import com.ecomapi.exceptions.Response;
import com.ecomapi.serviceimpl.CartServiceImpl;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addCart(@RequestParam("userId") int userId,@RequestParam("productId") int productId){
		if(this.cartServiceImpl.addCart(userId,productId))
			return Response.getResponse("Cart Added...",HttpStatus.CREATED, null);
		else
			return Response.getResponse("Cart Not Addedd...",HttpStatus.INTERNAL_SERVER_ERROR,null);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteCart(@RequestParam("userId") int cartId){
		this.cartServiceImpl.deleteCart(cartId);
		return Response.getResponse("Cart Delete...",HttpStatus.OK, null);
	}
	
	@GetMapping("/getcart")
	public ResponseEntity<Response> getCart(@RequestParam("userId") int userId){
		CartDto cart=this.cartServiceImpl.getMyCart(userId);
		if(!cart.getCarts().isEmpty())
			return Response.getResponse("Cart Found...",HttpStatus.FOUND, cart);
		else
			return Response.getResponse("Cart Not Found...",HttpStatus.NOT_FOUND, null);
	}
}





















