package com.Twoks.Twoks.module.category.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.Twoks.Twoks.module.book.entity.Book;
import com.Twoks.Twoks.utils.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Category extends BaseEntity {

	@Column(name = "code", columnDefinition = "VARCHAR(20)", nullable = false)
	private String code;

	@Column(name = "description", columnDefinition = "VARCHAR(200)", nullable = false)
	private String description;

	@JsonManagedReference("CategoryBook")
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Book> books = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
