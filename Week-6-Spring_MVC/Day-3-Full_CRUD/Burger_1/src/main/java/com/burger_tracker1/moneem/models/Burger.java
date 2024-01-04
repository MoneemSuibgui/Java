package com.burger_tracker1.moneem.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@NotNull(message="* Burger Name must not be blank ")
	@Size(min=3 ,max=100 ,message="* Burger Name must at least 3 Characters")
	private String burgerName;
	
	@NotNull(message="* Restaurant Name not be blank")
	@Size(min=5,message="* Restaurant Name must at least 5 Characters")
	private String restaurantName;
	
	@NotNull(message="* Rating must not be blank (between 0 and 10)")
	@Min(value=0,message="* Rating must at least 0")
	@Max(value=10,message="* Rating maximum must not more than 10 ")
	private Integer rating ;
	
	@NotNull(message="* Notes must not be blank")
	@Size(min=5,message="* Notes must at least 5 Characters")
	private String note;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	
	// Zero arguments Constructor
	public Burger() {}
	
	
	// getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	

	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
	@PrePersist
	public void onCreate() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt=new Date();
	}
	
	
	
}
