package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private double price;
	private String category;
	private String imageLink;
	private String description;
	private double rating;
	private int totalRating;
	private String addedByUserName;
	
	
	public OnlineProductDetails() {
		super();
	}
	public OnlineProductDetails(String productName, double price, String category, String imageLink, String description,
			double rating, String addedByUserName, int totalRating) {
		super();
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.imageLink = imageLink;
		this.description = description;
		this.rating = rating;
		this.addedByUserName = addedByUserName;
		this.totalRating = totalRating;
	}
	
	
	public int getTotalRating() {
		return totalRating;
	}
	public void setTotalRating(int totalRating) {
		this.totalRating = totalRating;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getAddedByUserName() {
		return addedByUserName;
	}
	public void setAddedByUserName(String addedByUserName) {
		this.addedByUserName = addedByUserName;
	}
	@Override
	public String toString() {
		return "OnlineProductStore [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", category=" + category + ", imageLink=" + imageLink + ", description=" + description + ", rating="
				+ rating + ", addedByUserName=" + addedByUserName + "]";
	}
	
	
	
}
