package com.boredApes.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String description;

	private String price;
	
	@Embedded
	@ElementCollection
	@Column(name="sizes")
	private Set<Size> sized = new HashSet<>();
	
	@Column(name="image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy = "product",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Rating>ratings = new ArrayList<>();
	
	@OneToMany(mappedBy = "product",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Review>reviews = new ArrayList<>();
	
	@Column(name="num_ratings")
	private int numRatings;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	private LocalDateTime createdAt;
	
	public Product() {
		
	}

	public Product(Long id, String title, String description, String price, Set<Size> sized, String imageUrl,
			List<Rating> ratings, List<Review> reviews, int numRatings, Category category, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.sized = sized;
		this.imageUrl = imageUrl;
		this.ratings = ratings;
		this.reviews = reviews;
		this.numRatings = numRatings;
		this.category = category;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Set<Size> getSized() {
		return sized;
	}

	public void setSized(Set<Size> sized) {
		this.sized = sized;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getNumRatings() {
		return numRatings;
	}

	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}




















