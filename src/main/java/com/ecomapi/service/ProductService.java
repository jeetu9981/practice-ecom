package com.ecomapi.service;

import java.util.List;

import com.ecomapi.entities.Product;

public interface ProductService {
	public boolean addProduct(Product cat);
	
	public boolean deleteProduct(int cat);
	
	public boolean updateProduct(Product cat);
	
	public Product getSingleProduct(int id);
	
	public List<Product> getAllProducts();
}
