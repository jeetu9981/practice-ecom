package com.ecomapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomapi.entities.Product;
import com.ecomapi.exceptions.Response;
import com.ecomapi.serviceimpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	
	@PostMapping("/add")
	public ResponseEntity<Response> addProduct(@ModelAttribute Product product){
		if(this.productServiceImpl.addProduct(product))
			return Response.getResponse("Product Added...",HttpStatus.CREATED,null);
		else
			return Response.getResponse("Product Not Added...",HttpStatus.FAILED_DEPENDENCY,product);
	}
	
	@GetMapping("/getsingleproduct")
	public ResponseEntity<Response> getSingleProduct(@RequestParam("id") int id){
		Product product=this.productServiceImpl.getSingleProduct(id);
		if(product!=null)
			return Response.getResponse("Product Found...",HttpStatus.FOUND,product);
		else
			return Response.getResponse("Product Not Found...",HttpStatus.NOT_FOUND,product);
	}
	
	@GetMapping("/getallproduct")
	public ResponseEntity<Response> getAllProduct(){
		List<Product> products=this.productServiceImpl.getAllProducts();
		if(!products.isEmpty())
			return Response.getResponse("Product Found...",HttpStatus.FOUND,products);
		else
			return Response.getResponse("Product Not Found...",HttpStatus.NOT_FOUND,products);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteProduct(@RequestParam("id") int id){
		this.productServiceImpl.deleteProduct(id);
		return Response.getResponse("Product Delete...",HttpStatus.OK,null);
	}
}
