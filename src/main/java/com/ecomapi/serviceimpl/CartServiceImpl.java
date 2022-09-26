package com.ecomapi.serviceimpl;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.Repository.CartRepo;
import com.ecomapi.dto.CartDto;
import com.ecomapi.entities.Cart;
import com.ecomapi.entities.Product;
import com.ecomapi.entities.User;
import com.ecomapi.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private UserServiceImpl UserServiceImpl;

	@Override
	public boolean addCart(int userId, int productId) {
		User user=new User();
		user.setId(userId);
		
		Product product =new Product();
		product.setId(productId);
		
		Cart cart=new Cart();
		cart.setProduct(product);
		cart.setUser(user);
		
		if(this.cartRepo.save(cart)!=null)
			return true;
		return false;
	}

	@Override
	public boolean deleteCart(int cartId) {
		this.cartRepo.deleteById(cartId);
		return true;
	}

	@Override
	public CartDto getMyCart(int userId) {
		User user=this.UserServiceImpl.getUser(userId);
		
		ArrayList<Product> products=new ArrayList<Product>();
		for(int i=0;i<user.getCart().size();i++)
			products.add(user.getCart().get(i).getProduct());
		
		CartDto cartDto=new CartDto();
		cartDto.setProducts(products);
		return cartDto;
	}

	@Transactional
	@Override
	public boolean deleteAllCart(int userId) {
		User user=new User();
		user.setId(userId);
		if(this.cartRepo.deleteByUserId(user)>0)
			return true;
		return false;
	}
	
	
	
	
}
