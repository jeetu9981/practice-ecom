package com.ecomapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.dto.OrderDto;
import com.ecomapi.entities.Order;
import com.ecomapi.exceptions.Response;
import com.ecomapi.serviceimpl.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Response> addOrder(@ModelAttribute Order order){
		if(this.orderServiceImpl.addOrder(order))
			return Response.getResponse("Order Added...",HttpStatus.CREATED,null);
		else
			return Response.getResponse("Order Not Addedd...",HttpStatus.INTERNAL_SERVER_ERROR,null);
	}
	
	@GetMapping("/getorder")
	public ResponseEntity<Response> getOrder(@RequestParam("userId") int userId){
		OrderDto odt=this.orderServiceImpl.getOrders(userId);
		if(odt!=null)
			return Response.getResponse("Order Found...",HttpStatus.FOUND,odt);
		else
			return Response.getResponse("Order Not Found...",HttpStatus.NOT_FOUND,null);
	}
}
