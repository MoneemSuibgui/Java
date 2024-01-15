package com.products_categories.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_categories.moneem.models.Category;
import com.products_categories.moneem.models.Product;
import com.products_categories.moneem.repositories.CategoryRepository;

@Service
public class CategoryService {

	// inject CategoryRepository to the CategoryService
	@Autowired
	private CategoryRepository categRepo;

	// create Category
	public Category add(Category category) {
		return categRepo.save(category);
	}

	// update Category
	public Category update(Category category) {
		return categRepo.save(category);
	}

	// get all Categories
	public List<Category> all() {
		return categRepo.findAll();
	}

	// get one Category
	public Category oneCategory(Long id) {
		return categRepo.findById(id).get();
	}
	
	// add product to products list of the specific category
	public Category addProduct(Product product,Category category) {
		category.getProducts().add(product);
		return categRepo.save(category);
	}
}
