package com.ecomapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderproducts")
public class OrderProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_products_id")
	private int id;
	
	@ManyToOne
	private Order order_products;
	
	@OneToOne
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder_products() {
		return order_products;
	}

	public void setOrder_products(Order order_products) {
		this.order_products = order_products;
	}

	public Product getProducts() {
		return product;
	}

	public void setProducts(Product products) {
		this.product = products;
	}
	
	
}	
