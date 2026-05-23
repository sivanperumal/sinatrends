package com.javacode.sinatrends.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false,unique = true)
	private String slug;
	
	private Boolean active;

	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String name, String slug, Boolean active, List<Collection> collections) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.active = active;
	}

	public long getId() {
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
	
	
}
