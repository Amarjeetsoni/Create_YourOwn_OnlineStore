package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineSuggestChangeOnProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int suggestChangeId;
	private String toShopKeeper;
	private String byUserId;
	private String ProductItemName;
	private String changeDetails;
	private boolean isAccepted;
	
	
	public OnlineSuggestChangeOnProduct(String toShopKeeper, String byUserId, String productItemName,
			String changeDetails, boolean accepted) {
		super();
		this.toShopKeeper = toShopKeeper;
		this.byUserId = byUserId;
		ProductItemName = productItemName;
		this.changeDetails = changeDetails;
		this.isAccepted = accepted;
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
	public String getProductItemName() {
		return ProductItemName;
	}
	public void setProductItemName(String productItemName) {
		ProductItemName = productItemName;
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
				+ ", byUserId=" + byUserId + ", ProductItemName=" + ProductItemName + ", changeDetails=" + changeDetails
				+ ", isAccepted=" + isAccepted + "]";
	}
	
	
	
}
