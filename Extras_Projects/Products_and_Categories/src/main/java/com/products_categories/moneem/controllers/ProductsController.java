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
public class ProductsController {
	 
	// inject ProductService to ProductsController
	@Autowired
	private ProductService prodServ;
	@Autowired
	private CategoryService categServ;
	
	
	// Display route  product form
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "createProduct.jsp";
	}
	
	// Action route submit the form add product to the database
	@PostMapping("/create/product")
	public String saveProduct(@Valid @ModelAttribute("product")Product product,BindingResult result) {
		if(result.hasErrors()) {
			return "createProduct.jsp";
		}
		// else save product and redirect to home page
		prodServ.add(product);
		return "redirect:/";
	}
	
	// Display route (show one product)
	@GetMapping("/products/{productId}")
	public String showProduct(@PathVariable("productId") Long productId,Model modelView,@ModelAttribute("categoryProduct")Category category) {
		// send the product & all categories to the page oneProduct.jsp
		modelView.addAttribute("product", prodServ.oneProduct(productId));
		modelView.addAttribute("categories",categServ.all());
		return"oneProduct.jsp";
	}
	
	
	// Action route add category to the product
	@PostMapping("/add/category/{prodId}")
	public String addCategoryToProduct(@RequestParam("categoryId") Long id,@PathVariable("prodId") Long prodId,Model modelView) {
	
	Product prod=prodServ.oneProduct(prodId);
	Category category=categServ.oneCategory(id);
	// add the category to the list of product categories
	prodServ.addCategory(category, prod);
	modelView.addAttribute("categories", categServ.all());
	return "redirect:/products/"+prod.getId();
	
	}
}
