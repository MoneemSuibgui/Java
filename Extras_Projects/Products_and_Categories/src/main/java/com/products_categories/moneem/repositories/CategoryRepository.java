package com.products_categories.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products_categories.moneem.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

	// get all Categories
	List<Category> findAll();
}
