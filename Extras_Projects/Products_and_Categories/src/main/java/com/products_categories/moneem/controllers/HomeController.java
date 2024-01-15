package com.products_categories.moneem.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.products_categories.moneem.models.Category;
import com.products_categories.moneem.models.Product;
import com.products_categories.moneem.services.CategoryService;
import com.products_categories.moneem.services.ProductService;

@Controller
public class HomeController {
	
	// inject ProductsService & CategoryService for the HomeController
	private final ProductService prodServ;
	private final CategoryService categServ;
	
	public HomeController(ProductService prodServ,CategoryService categServ) {
		this.categServ=categServ;
		this.prodServ=prodServ;
	}

	// Display route for the home page
	@GetMapping("/")
	public String dashboard(Model modelView) {
		// get 2 lists of products & categories
		List<Product> products= prodServ.allProducts();
		List<Category> categories =categServ.all();
		
		// send those tow lists to home page
		modelView.addAttribute("products", products);
		modelView.addAttribute("categories", categories);
		
		return "home.jsp";
	}
	
}
