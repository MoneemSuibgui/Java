package com.fakeinstagram.moneem.repositories;




import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fakeinstagram.moneem.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	// we just need find user by email to check the user email when user login 
	Optional<User> findByEmail(String email);
}
