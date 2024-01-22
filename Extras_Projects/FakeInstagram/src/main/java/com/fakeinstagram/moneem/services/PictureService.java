package com.fakeinstagram.moneem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fakeinstagram.moneem.models.Picture;
import com.fakeinstagram.moneem.models.User;
import com.fakeinstagram.moneem.repositories.PictureRepository;

@Service
public class PictureService {

	@Autowired
	private PictureRepository repository;
	
	// upload picture and save it 
	public void uploadPicture(String desc,User user,String url) {
		Picture picture=new Picture(url,desc,user);
		this.repository.save(picture);
	}
	
}
