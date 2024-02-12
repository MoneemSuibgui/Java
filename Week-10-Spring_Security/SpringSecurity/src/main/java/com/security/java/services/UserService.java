package com.security.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.java.models.User;
import com.security.java.repositories.RoleRepository;
import com.security.java.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	// save user with user role
	public void saveUserWithUserRole(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		this.userRepository.save(user);
	}
	
	
	// save user with admin role
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}
	
	// find user by username
	public User findByName(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	
}
