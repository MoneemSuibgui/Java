package com.fun_pages.moneem.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="celebrities")
public class Celebrity {
	


	// member variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Celebrity name must not be null")
	@Size(min=3,max=10,message="Celebrity name must be between 3 and 10 characters")
	private String celebrityName;
	
	@NotNull(message ="Celebrity Details must not be null")
	@Size(min=10,message="Celebrity details must at least 10 characters")
	private String details;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// Connection(user & celebrities)
	// one user can have many celebrities/one celebrity belongs to one user
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	// many to many connection (one celebrity can followed by many users )
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="follow",
			joinColumns=@JoinColumn(name="celebrity_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	List<User> followers;
	
	//beans constructor
	public Celebrity() {}
	
	
	// getters&setters
	@PrePersist
	private void createdOn() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	private void updatedOn() {
		this.updatedAt= new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCelebrityName() {
		return celebrityName;
	}

	public void setCelebrityName(String celebrityName) {
		this.celebrityName = celebrityName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public List<User> getFollowers() {
		return followers;
	}


	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}



}
