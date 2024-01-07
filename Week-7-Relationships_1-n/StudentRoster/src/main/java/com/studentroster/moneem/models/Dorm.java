package com.studentroster.moneem.models;

import java.util.Date;
import java.util.List;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dorms")
public class Dorm {

	// Member variables
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="* Dorm name must not be null")
	@Size(min=3,message="* Dorm name must at least be 3 characters")
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(updatable=false)
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// RelationShip(One dorm can have many students)
	@OneToMany(mappedBy="dorm",fetch=FetchType.LAZY)
	private List<Student> students;
	
	
	
	// zero arguments constructor
	public Dorm() {}
	
	// getters & setters
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
