package com.Twoks.Twoks.module.author.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.Twoks.Twoks.module.book.entity.Book;
import com.Twoks.Twoks.utils.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "author")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Author extends BaseEntity {

	@Column(name = "name", columnDefinition = "VARCHAR(200)", nullable = false)
	private String name;

	@Column(name = "sur_name", columnDefinition = "VARCHAR(200)", nullable = false)
	private String surName;

	@Column(name = "phone", columnDefinition = "VARCHAR(10)")
	private String phone;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author", foreignKey = @ForeignKey(name = "book_author_fk")), inverseJoinColumns = @JoinColumn(name = "book", foreignKey = @ForeignKey(name = "author_book_fk")), uniqueConstraints = {
			@UniqueConstraint(name = "quote_main_industry_uk", columnNames = { "author", "book" }) })
	private List<Book> books = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
