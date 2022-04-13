package com.example.tuukankirjakauppa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

	public Category(String name) {
		super();
		this.name = name;
	}

	public Category() {
		super();
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public String getName() {
		return name;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public void setName(String name) {
		
		this.name = name;
	}

}
