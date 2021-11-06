package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineSuggestChangeProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int suggestChangeId;
	private String toShopKeeper;
	private String byUserId;
	private int ProductItemId;
	private String changeDetails;
	private String commentShopKeeper;
	private boolean isAccepted;
	
	public OnlineSuggestChangeProduct(){
		
	}
	
	public OnlineSuggestChangeProduct(String toShopKeeper, String byUserId, int productItemId,
			String changeDetails, boolean accepted, String commentShopKeeper) {
		super();
		this.toShopKeeper = toShopKeeper;
		this.byUserId = byUserId;
		this.ProductItemId = productItemId;
		this.changeDetails = changeDetails;
		this.isAccepted = accepted;
		this.commentShopKeeper = commentShopKeeper;
	}
	
	
	
	public String getCommentShopKeeper() {
		return commentShopKeeper;
	}

	public void setCommentShopKeeper(String commentShopKeeper) {
		this.commentShopKeeper = commentShopKeeper;
	}

	public int getSuggestChangeId() {
		return suggestChangeId;
	}


	public void setSuggestChangeId(int suggestChangeId) {
		this.suggestChangeId = suggestChangeId;
	}


	public boolean isAccepted() {
		return isAccepted;
	}


	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public String getToShopKeeper() {
		return toShopKeeper;
	}
	public void setToShopKeeper(String toShopKeeper) {
		this.toShopKeeper = toShopKeeper;
	}
	public String getByUserId() {
		return byUserId;
	}
	public void setByUserId(String byUserId) {
		this.byUserId = byUserId;
	}
	public int getProductItemId() {
		return ProductItemId;
	}
	public void setProductItemName(int productItemId) {
		this.ProductItemId = productItemId;
	}
	public String getChangeDetails() {
		return changeDetails;
	}
	public void setChangeDetails(String changeDetails) {
		this.changeDetails = changeDetails;
	}
	@Override
	public String toString() {
		return "OnlineSuggestChangeOnProduct [suggestChangeId=" + suggestChangeId + ", toShopKeeper=" + toShopKeeper
				+ ", byUserId=" + byUserId + ", ProductItemId=" + ProductItemId + ", changeDetails=" + changeDetails
				+ ", isAccepted=" + isAccepted + "]";
	}
	
	
	
}
