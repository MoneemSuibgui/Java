package com.book_api.moneem.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=3,max=100)
	private String title;
	
	@NotNull
	@Size(min=5,max=300)
	private String description;
	
	@NotNull
	@Size(min=4,max=20)
	private String Language;
	
	@NotNull
	@Min(20)
	private Integer numberOfPages;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;

	
	
	
	
	// zero args constructor
	public Book() {
	}

	// Overloaded constructor
	public Book(@NotNull @Size(min = 3, max = 100) String title,
			@NotNull @Size(min = 5, max = 300) String description, @NotNull @Size(min = 4, max = 20) String language,
			@NotNull @Min(20) Integer numberOfPages) {
		this.title = title;
		this.description = description;
		Language = language;
		this.numberOfPages = numberOfPages;

	}
	
	// Getters and Setters
	
	//  before we save an object for the first time it will create the created_at field 
	@PrePersist
	protected void onCreate() {
		this.created_at=new Date();
	}
	

	// every time we update an object it will updated the updated_at field
	@PreUpdate
	protected void onUpdate() {
		this.updated_at=new Date();
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	
	

}
