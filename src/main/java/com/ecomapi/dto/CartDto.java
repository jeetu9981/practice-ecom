package com.ecomapi.dto;

import java.util.List;

import com.ecomapi.entities.Product;

public class CartDto {
	private List<Product> products;

	public List<Product> getCarts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
