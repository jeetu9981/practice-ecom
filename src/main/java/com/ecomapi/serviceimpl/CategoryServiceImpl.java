package com.ecomapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapi.Repository.CategoryRepo;
import com.ecomapi.entities.Category;
import com.ecomapi.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public boolean addCategory(Category cat) {
		if(this.categoryRepo.save(cat)!=null)
			return true;
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		this.categoryRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateCategory(Category cat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category getSingleCategory(int id) {
		Optional<Category> optional=this.categoryRepo.findById(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) this.categoryRepo.findAll();
	}

}
