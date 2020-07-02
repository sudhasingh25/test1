package com.bookstore.entity;
// Generated May 1, 2020 9:29:51 AM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Book generated by hbm2java
 */
@Entity
@Table(name = "book", catalog = "bookstoredb", uniqueConstraints = { @UniqueConstraint(columnNames = "book_id"),
		@UniqueConstraint(columnNames = "title") })
public class Book implements java.io.Serializable {

	private BookId id;
	private Category category;
	private Set<Review> reviews = new HashSet<Review>(0);
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public Book() {
	}

	public Book(BookId id, Category category) {
		this.id = id;
		this.category = category;
	}

	public Book(BookId id, Category category, Set<Review> reviews, Set<OrderDetail> orderDetails) {
		this.id = id;
		this.category = category;
		this.reviews = reviews;
		this.orderDetails = orderDetails;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "bookId", column = @Column(name = "book_id", unique = true, nullable = false)),
			@AttributeOverride(name = "title", column = @Column(name = "title", unique = true, nullable = false, length = 128)),
			@AttributeOverride(name = "author", column = @Column(name = "author", nullable = false, length = 64)),
			@AttributeOverride(name = "description", column = @Column(name = "description", nullable = false, length = 16777215)),
			@AttributeOverride(name = "isbn", column = @Column(name = "isbn", nullable = false, length = 15)),
			@AttributeOverride(name = "image", column = @Column(name = "image", nullable = false)),
			@AttributeOverride(name = "price", column = @Column(name = "price", nullable = false, precision = 12, scale = 0)),
			@AttributeOverride(name = "publishDate", column = @Column(name = "publish_date", nullable = false, length = 10)),
			@AttributeOverride(name = "lastUpdateTime", column = @Column(name = "last_update_time", nullable = false, length = 19)),
			@AttributeOverride(name = "categoryId", column = @Column(name = "category_id", nullable = false)) })
	public BookId getId() {
		return this.id;
	}

	public void setId(BookId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false, insertable = false, updatable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}