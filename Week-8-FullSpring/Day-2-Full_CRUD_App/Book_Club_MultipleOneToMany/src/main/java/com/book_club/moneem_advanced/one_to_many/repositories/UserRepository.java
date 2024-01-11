package com.book_club.moneem_advanced.one_to_many.repositories;




import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book_club.moneem_advanced.one_to_many.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	// we just need find user by email to check the user email when user login 
	Optional<User> findByEmail(String email);
}
