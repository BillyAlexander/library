package com.Twoks.Twoks.module.book.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.Twoks.Twoks.module.category.entity.Category;
import com.Twoks.Twoks.module.editorial.entity.Editorial;
import com.Twoks.Twoks.utils.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Book extends BaseEntity {

	@Column(name = "title", columnDefinition = "VARCHAR(200)", nullable = false)
	private String title;

	@JsonBackReference("EditorialBook")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "editorial", foreignKey = @ForeignKey(name = "book_editorial_fk"))
	private Editorial editorial;

	@JsonBackReference("CategoryBook")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "category", foreignKey = @ForeignKey(name = "book_category_fk"))
	private Category category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
