package com.security.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.java.models.Role;
import com.security.java.models.User;
import com.security.java.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementaion implements UserDetailsService {

	// inject UserRepository
	private UserRepository userRepository;

	public UserDetailsServiceImplementaion(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// 1 -- load user by username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found !!!");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),getAuthorities(user));
	}
	
	
	 // 2 -- get user authorities
    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

}