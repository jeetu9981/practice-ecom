package com.ecomapi.service;

import java.util.List;

import com.ecomapi.entities.Category;

public interface CategoryService {
	public boolean addCategory(Category cat);
	
	public boolean deleteCategory(int cat);
	
	public boolean updateCategory(Category cat);
	
	public Category getSingleCategory(int id);
	
	public List<Category> getAllCategories();
}
