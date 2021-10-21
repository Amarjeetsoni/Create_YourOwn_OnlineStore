package com.cg.OnlineStore.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineShopKeeper {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shopId;
	private String shopKeeperUserName;
	private String shopKeeperPassword;
	private int totalProductAdded;
	private String emailId;
	private String mobileNumber;
	private String nameOfShop;
	private String Address;
	private String shopType;
	private double rating;
	private boolean isApproved;
	private boolean isActive;
	private String securityQuestion;
	private String answer;
	
	public OnlineShopKeeper(){
		
	}
		
	public OnlineShopKeeper(String shopKeeperUserName, String shopKeeperPassword, int totalProductAdded, String emailId,
			String mobileNumber, String nameOfShop, String address, String shopType, double rating, boolean isApproved,
			boolean isActive, String securityQuestion, String answer) {
		super();
		this.shopKeeperUserName = shopKeeperUserName;
		this.shopKeeperPassword = shopKeeperPassword;
		this.totalProductAdded = totalProductAdded;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.nameOfShop = nameOfShop;
		Address = address;
		this.shopType = shopType;
		this.rating = rating;
		this.isApproved = isApproved;
		this.isActive = isActive;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	


	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}



	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}




	public String getAnswer() {
		return answer;
	}




	public void setAnswer(String answer) {
		this.answer = answer;
	}




	public String getShopType() {
		return shopType;
	}



	public void setShopType(String shopType) {
		this.shopType = shopType;
	}



	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopKeeperUserName() {
		return shopKeeperUserName;
	}
	public void setShopKeeperUserName(String shopKeeperUserName) {
		this.shopKeeperUserName = shopKeeperUserName;
	}
	public String getShopKeeperPassword() {
		return shopKeeperPassword;
	}
	public void setShopKeeperPassword(String shopKeeperPassword) {
		this.shopKeeperPassword = shopKeeperPassword;
	}
	public String getNameOfShop() {
		return nameOfShop;
	}
	public void setNameOfShop(String nameOfShop) {
		this.nameOfShop = nameOfShop;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public int getTotalProductAdded() {
		return totalProductAdded;
	}
	public void setTotalProductAdded(int totalProductAdded) {
		this.totalProductAdded = totalProductAdded;
	}
	
	@Override
	public String toString() {
		return "OnlineShopKeeper [shopId=" + shopId + ", shopKeeperUserName=" + shopKeeperUserName
				+ ", shopKeeperPassword=" + shopKeeperPassword + ", totalProductAdded=" + totalProductAdded
				+ ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", nameOfShop=" + nameOfShop
				+ ", Address=" + Address + ", shopType=" + shopType + ", rating=" + rating + ", isApproved="
				+ isApproved + ", isActive=" + isActive + ", securityQuestion=" + securityQuestion + ", answer="
				+ answer + "]";
	}
	
	
}
