package com.login_registration.moneem.models;

import java.time.LocalTime;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name must not be blank!")
	private String name;

	@NotEmpty(message = "Day must not be blank!")
	private String day;

	@NotNull(message = "Price required!")
	@Min(value = 0, message = "Price must be greater than or equal to 0")
	private Integer price;

	@NotEmpty(message = "Description must not be blank!")
	private String description;

	// @NotEmpty(message = "Time must not be blank!")
	private LocalTime time;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(updatable = false)
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// Many to one creator or instructor can create many courses
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;

	// M:M courses can have many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Student> studentsCourse;

	// empty constructor

	public Course() {

	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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

	public List<Student> getStudentsCourse() {
		return studentsCourse;
	}

	public void setStudentsCourse(List<Student> studentsCourse) {
		this.studentsCourse = studentsCourse;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
