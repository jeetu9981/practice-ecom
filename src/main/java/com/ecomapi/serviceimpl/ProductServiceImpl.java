package com.ecomapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.Repository.ProductRepo;
import com.ecomapi.entities.Category;
import com.ecomapi.entities.Product;
import com.ecomapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	@Override
	public boolean addProduct(Product pro) {
		Category category=new Category();
		category.setId(pro.getCategory().getId());
		
		pro.setCategory(category);
		
		if(this.productRepo.save(pro)!=null)
			return true;
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		this.productRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateProduct(Product cat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getSingleProduct(int id) {
		Optional<Product> opt=this.productRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) this.productRepo.findAll();
	}

}
