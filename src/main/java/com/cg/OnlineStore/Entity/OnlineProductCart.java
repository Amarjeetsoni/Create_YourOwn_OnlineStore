package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineProductCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int productID;
	private String byUser;
	
	public OnlineProductCart(int productID, String byUser) {
		super();
		this.productID = productID;
		this.byUser = byUser;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getByUser() {
		return byUser;
	}
	public void setByUser(String byUser) {
		this.byUser = byUser;
	}
	@Override
	public String toString() {
		return "ProductCart [cartId=" + cartId + ", productID=" + productID + ", byUser=" + byUser + "]";
	}
	
}
