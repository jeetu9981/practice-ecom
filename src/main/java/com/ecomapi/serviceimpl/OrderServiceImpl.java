package com.ecomapi.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.Repository.OrderRepo;
import com.ecomapi.dto.OrderDto;
import com.ecomapi.entities.Order;
import com.ecomapi.entities.OrderProducts;
import com.ecomapi.entities.Product;
import com.ecomapi.entities.User;
import com.ecomapi.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderProductsServiceImpl orderProductsServiceImpl;
	
	@Autowired 
	private CartServiceImpl cartServiceImpl;
	
	@Override
	public boolean addOrder(Order order) {
		Order o=this.orderRepo.save(order);
		if(o!=null) {
			ArrayList<OrderProducts> op=new ArrayList<OrderProducts>();
			
			for(int i=0;i<order.getProductIds().size();i++) {
				OrderProducts orderProduct=new OrderProducts();
				
				Order ord=new Order();
				ord.setId(o.getId());
				
				Product product=new Product();
				product.setId(order.getProductIds().get(i));
				
				orderProduct.setProducts(product);
				orderProduct.setOrder_products(o);
				
				op.add(orderProduct);
			}
			
			
			if(this.orderProductsServiceImpl.addOrderProducts(op)) {
				if(this.cartServiceImpl.deleteAllCart(o.getUser().getId()))
					return true;
			}
		}
		return false;
	}

	@Override
	public OrderDto getOrders(int userId) {
		User u=new User();
		u.setId(userId);
		Order o=this.orderRepo.findByUser(u);
		if(o!=null) {
			OrderDto odt=new OrderDto();
			odt.setAddress(o.getAddress());
			odt.setMobile(o.getMobile());
			odt.setTotal(o.getTotal_price());
			ArrayList<Product> p=new ArrayList<Product>();
			
			for(int i=0;i<o.getProducts().size();i++) {
				p.add(o.getProducts().get(i).getProducts());
			}
			
			odt.setProducts(p);
			return odt;
		}
		return null;
	}


}
