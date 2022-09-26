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

import com.ecomapi.entities.Category;
import com.ecomapi.entities.User;
import com.ecomapi.exceptions.Response;
import com.ecomapi.serviceimpl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired 
	private CategoryServiceImpl categoryServiceImpl;
	
	
	@PostMapping("/add")
	public ResponseEntity<Response> add(@ModelAttribute Category category){
		if(this.categoryServiceImpl.addCategory(category))
			return Response.getResponse("Category Added..",HttpStatus.CREATED,null);
		else
			return Response.getResponse("Not Created...",HttpStatus.BAD_REQUEST, category);
	}
	
	@GetMapping("/singlecategory")
	public ResponseEntity<Response> getSingleCategory(@RequestParam("id") int id){
		Category category=this.categoryServiceImpl.getSingleCategory(id);
		if(category!=null)
			return Response.getResponse("Category Found...",HttpStatus.FOUND,category);
		else
			return Response.getResponse("No Category Found....",HttpStatus.NOT_FOUND,null);
	}
	
	@GetMapping("/allcategory")
	public ResponseEntity<Response> getAllCategory(){
		List<Category> categories=this.categoryServiceImpl.getAllCategories();
		if(!categories.isEmpty())
			return Response.getResponse("Category Found...",HttpStatus.FOUND,categories);
		else
			return Response.getResponse("No Category Found....",HttpStatus.NOT_FOUND,null);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteCategory(@RequestParam("id") int id){
		this.categoryServiceImpl.deleteCategory(id);
		return Response.getResponse("Category Delete...",HttpStatus.FOUND,null);
	}
}
