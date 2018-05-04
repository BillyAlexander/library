package com.Twoks.Twoks.module.editorial.entity;

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
@Table(name = "editorial")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Editorial extends BaseEntity {

	@Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
	private String name;

	@Column(name = "address", columnDefinition = "VARCHAR(200)", nullable = false)
	private String address;

	@JsonManagedReference("EditorialBook")
	@OneToMany(mappedBy = "editorial", fetch = FetchType.LAZY)
	private List<Book> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
