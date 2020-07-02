package com.bookstore.entity;
// Generated May 1, 2020 9:29:51 AM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "bookstoredb")
/*
@NamedQueries({
	@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c ORDER BY c.name"),
	@NamedQuery(name = "Category.countAll", query = "SELECT COUNT(*) FROM Category"),
	@NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name")
})
*/
public class Category implements java.io.Serializable {

	private static final GenerationType IDENTITY = null;
	private int categoryId;
	private String name;
	private Set<Book> books = new HashSet<Book>(0);

	public Category() {
	}

	public Category( String name) {
		//this.categoryId = categoryId;
		this.name = name;
	}

	public Category(String name, Set<Book> books) {
		//this.categoryId = categoryId;
		this.name = name;
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}