package com.admin_dashboard.security.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.admin_dashboard.security.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	// find all roles;
	List<Role> findAll();
	
	// find all roles by name
	List<Role> findByName(String name);
}
