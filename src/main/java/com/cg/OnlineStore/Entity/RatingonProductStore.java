package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RatingonProductStore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingProductId;
	private double rating;
	private int productName;
	private String addedByShopKeeper;
	private String Message;
	private String category;
	private String ratingBy;
	
	public RatingonProductStore() {
		
	}
	
	public RatingonProductStore(double rating, int productName, String addedByShopKeeper,
			String message, String c, String ratingBy) {
		super();
		this.rating = rating;
		this.productName = productName;
		this.addedByShopKeeper = addedByShopKeeper;
		Message = message;
		this.category = c;
		this.ratingBy = ratingBy;
	}
	
	public String getRatingBy() {
		return ratingBy;
	}

	public void setRatingBy(String ratingBy) {
		this.ratingBy = ratingBy;
	}

	public int getRatingProductId() {
		return ratingProductId;
	}
	public void setRatingProductId(int ratingProductId) {
		this.ratingProductId = ratingProductId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getProductName() {
		return productName;
	}
	public void setProductName(int productName) {
		this.productName = productName;
	}
	public String getAddedByShopKeeper() {
		return addedByShopKeeper;
	}
	public void setAddedByShopKeeper(String addedByShopKeeper) {
		this.addedByShopKeeper = addedByShopKeeper;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "RatingonProductByShopKeeper [ratingProductId=" + ratingProductId + ", rating=" + rating
				+ ", productName=" + productName + ", addedByShopKeeper=" + addedByShopKeeper + ", Message=" + Message
				+ ", category=" + category + ", ratingBy=" + ratingBy + "]";
	}
	
	
}
