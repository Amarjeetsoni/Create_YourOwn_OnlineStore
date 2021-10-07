package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

public interface UserServices {

	public boolean isUserDtailsCorrect(OnlineUser user);
	
	public boolean registerUser(OnlineUser user);
	
	public OnlineUser getUserDetails();
	
	public OnlineUserDashboardDetails getUserDashboardDetails();
	
	public List<OnlineProductDetails> getProductDetails();
	
	public boolean addRatinginProduct();
	
	public boolean addRatingOfshopKeepers();
	
	public boolean chatStore(OnlineChatDetails chat);
	
	public boolean addProductInCart(OnlineProductDetails productDetail);
	
	public OnlineShopKeeper getAllShopKepperShopDetails();
	
	
	
	
}
