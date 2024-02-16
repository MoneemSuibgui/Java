package com.admin_dashboard.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.admin_dashboard.security.model.User;
import com.admin_dashboard.security.repository.RoleRepository;
import com.admin_dashboard.security.repository.UserRepository;

@Service
public class UserService {

	// injcet UserRepository
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private RoleRepository roleRepository;

	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.roleRepository = roleRepository;
	}

	// save user with specific role
	public void saveUserWithRole(User user,String role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName(role));
		userRepository.save(user);
	}
	
	// update user with specific role
		public void updateUser(User user) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}
		
		// upgrade user
		public User upgradeUser(User user) {
			user.setRoles(this.roleRepository.findByName("ROLE_ADMIN"));
			return this.userRepository.save(user);
		}

	// find user by email
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	// get all users
	public List<User> allUsers(){
		return this.userRepository.findAll();
	}
	
	
	// delete user
	public void deleteUser(User user) {
		this.userRepository.delete(user);
	}
	// find User by id
	
	public User findById(Long id) {
		Optional<User> optionalUser=this.userRepository.findById(id);
		if(optionalUser.isEmpty()) {
			return null;
		}return optionalUser.get();
	}
	
}
