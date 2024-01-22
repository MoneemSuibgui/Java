package com.fakeinstagram.moneem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	// member variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Username is required!")
	@Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters")
	private String userName;

	@NotEmpty(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	private String email;

	@NotEmpty(message = "Password is required!")
	@Column(length = 3000)
	@Size(min=8,max=200, message = "Password must be between 8 and 200 characters")
	private String password;

	// @Transient annotation(this field doesn't stored into the database when
	// created user object)
	@Transient
	@NotEmpty(message = "Confirm Password is required!")
	 @Column(length = 3000)
	@Size(min=8,max=200, message = "Confirm Password must be between 8 and 200 characters")
	private String confirmPass;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(updatable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToMany(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Picture> pictures;
	
	
	// beans constructor (zero arguments)
	public User() {
	}

	// getters & setters
	@PrePersist
	public void createdOn() {
		this.createdAt = new Date();
	}

	@PreUpdate
	public void updatedOn() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

}
