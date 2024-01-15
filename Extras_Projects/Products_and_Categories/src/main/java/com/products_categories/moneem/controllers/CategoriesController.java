package com.products_categories.moneem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.products_categories.moneem.models.Category;
import com.products_categories.moneem.models.Product;
import com.products_categories.moneem.services.CategoryService;
import com.products_categories.moneem.services.ProductService;

@Controller
public class CategoriesController {
	
	// inject CategoryService 
	@Autowired
	private CategoryService categServ;
	@Autowired
	private ProductService prodServ;

	// Display route for Category form
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
	return "createCategory.jsp";
	}

	// Action route submit the form(if there's no errors)
	@PostMapping("/create/category")
	public String saveCategory(@Valid @ModelAttribute("category") Category category,BindingResult result){
		if(result.hasErrors()) {
			return"createCategory.jsp";
		}else {
			categServ.add(category);
			return "redirect:/";
		}
	}
	
	// Display route (show one category)
		@GetMapping("/categories/{categoryId}")
		public String showProduct(@PathVariable("categoryId") Long categoryId,Model modelView) {
			// send the category & all products to the page oneProduct.jsp
			modelView.addAttribute("category", categServ.oneCategory(categoryId));
			modelView.addAttribute("products",prodServ.allProducts());
			return "oneCategory.jsp";
		}
		
	// Action route (add product to category)
		@PostMapping("/add/product/{categoryId}")
		public String addProduct(@RequestParam("productId") Long productId,@PathVariable("categoryId") Long categoryId,Model modelView) {
			Category category=categServ.oneCategory(categoryId);
			Product product=prodServ.oneProduct(productId);
			categServ.addProduct(product, category);
			return "redirect:/categories/"+category.getId();
		}
		
}
