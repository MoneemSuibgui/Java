package com.admin_dashboard.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.admin_dashboard.security.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	List<User> findAll();
}
