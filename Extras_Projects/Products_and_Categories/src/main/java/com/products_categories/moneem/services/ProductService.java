package com.products_categories.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products_categories.moneem.models.Category;
import com.products_categories.moneem.models.Product;
import com.products_categories.moneem.repositories.ProductRepository;

@Service
public class ProductService {

	// inject ProductRepository to the ProductService
	@Autowired
	private ProductRepository prodRepo;
	
	
	// create product
	public Product add(Product product) {
		return prodRepo.save(product);
	}
	
	// update product
		public Product update(Product product) {
			return prodRepo.save(product);
		}
		
	
	// get all product
	public List<Product> allProducts(){
		return prodRepo.findAll();
	}
	
	// get one product
	public Product oneProduct(Long id) {
		return prodRepo.findById(id).get();
	}
	
	// add one category to the specific product
	public Product addCategory(Category category, Product product) {
		// get the product and the category
		// add to categories list of product the category and save
		product.getCategories().add(category);
		return prodRepo.save(product);
		
	}
	
	
}
