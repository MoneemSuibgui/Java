package com.dojosninjas.moneem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ninjas")
public class Ninja {

	// Member Variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	@NotNull(message = "* FirstName must not be null")
	@Size(min = 3, max = 10, message = "* First Name must at least 3 Characters")
	private String firstName;

	@NotNull(message = "* Last Name must not be null")
	@Size(min = 3, max = 10, message = "* Last Name must at least 3 Characters")
	private String lastName;

	@NotNull(message = "* FirstName must not be null")
	@Min(value = 18, message = "* Age must at least 18 years old")
	private Integer age;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// relationShip (many ninjas could belongs to one dojo)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dojo_id")
	private Dojo dojo;

	// zero arguments constructor
	public Ninja() {
	}

	// getters and setters

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

}
