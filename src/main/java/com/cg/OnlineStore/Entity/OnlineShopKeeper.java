package com.cg.OnlineStore.Entity;

import java.util.ArrayList;

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
	private String nameOfShop;
	private String Address;
	private String shopType;
	private double rating;
	private boolean isApproved;
	private boolean isActive;
	
	public OnlineShopKeeper(String shopKeeperUserName, String shopType, String shopKeeperPassword, int totalProductAdded,
			String nameOfShop, String address, double rating, ArrayList<String> ratingMessage, boolean isApproved, boolean isActive) {
		super();
		this.shopKeeperUserName = shopKeeperUserName;
		this.shopKeeperPassword = shopKeeperPassword;
		this.totalProductAdded = totalProductAdded;
		this.isApproved = isApproved;
		this.nameOfShop = nameOfShop;
		Address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.shopType = shopType;
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
				+ ", nameOfShop=" + nameOfShop + ", Address=" + Address + ", shopType=" + shopType + ", rating="
				+ rating + ", isApproved=" + isApproved + ", isActive=" + isActive + "]";
	}
	
	
}
