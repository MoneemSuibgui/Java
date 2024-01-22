package com.fakeinstagram.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fakeinstagram.moneem.models.Picture;
import com.fakeinstagram.moneem.models.User;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

	// get all pictures by user
	List<Picture> findAllByUser(User user);
	
	
}
