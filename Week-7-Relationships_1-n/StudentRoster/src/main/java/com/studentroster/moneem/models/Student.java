package com.studentroster.moneem.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Student {

	// All member variables
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@NotNull(message="* Student Name must be not null")
	@Size(min=3,message="* Student Name must at least 3 Characters")
	private String studentName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(updatable=false)
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	// RelationShip(one or many Student belong to one dorm)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dorm_id")
	private Dorm dorm;
	
	
	// Empty constructor
	public Student() {}
	
	
	
	// getters and setters
	
	@PrePersist
	public void createdOn() {
		this.createdAt=new Date();
	}
	
	@PreUpdate
	public void updatedOn() {
		this.updatedAt=new Date();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
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



	public Dorm getDorm() {
		return dorm;
	}



	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
	
	
}
