package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RatingOnShopKeeper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingId;
	private double rating;
	private String customerUserName;
	private String Message;
	public RatingOnShopKeeper(double rating, String customerUserName, String message) {
		super();
		this.rating = rating;
		this.customerUserName = customerUserName;
		Message = message;
	}
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	@Override
	public String toString() {
		return "RatingOnShopKeeper [ratingId=" + ratingId + ", rating=" + rating + ", customerUserName="
				+ customerUserName + ", Message=" + Message + "]";
	}
	
	
	
}
