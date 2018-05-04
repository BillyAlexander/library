package com.Twoks.Twoks.module.bookshelves.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.Twoks.Twoks.module.category.entity.Category;
import com.Twoks.Twoks.utils.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bookshelves")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BookShelves extends BaseEntity {

	@Column(name = "description", columnDefinition = "VARCHAR(200)", nullable = false)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "bookshelves_category", joinColumns = @JoinColumn(name = "category", foreignKey = @ForeignKey(name = "category_bookshelves_fk")), inverseJoinColumns = @JoinColumn(name = "bookshelves", foreignKey = @ForeignKey(name = "bookshelves_category_fk")), uniqueConstraints = {
			@UniqueConstraint(name = "bookshelves_category_uk", columnNames = { "category", "bookshelves" }) })
	private List<Category> categories = new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
