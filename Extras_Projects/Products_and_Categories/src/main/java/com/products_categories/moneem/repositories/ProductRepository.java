package com.products_categories.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products_categories.moneem.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

	// all products
	List<Product> findAll();
	
}
