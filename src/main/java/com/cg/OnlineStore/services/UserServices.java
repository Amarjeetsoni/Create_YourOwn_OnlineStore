package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

public interface UserServices {

	public String isUserDtailsCorrect(String email, String mobileNumber);
	
	public boolean registerUser(OnlineUser user);
	
	public OnlineUser getUserDetails(String emailId);
	
	public OnlineUserDashboardDetails getUserDashboardDetails();
	
	public List<OnlineProductDetails> getProductDetails();
	
	public boolean addRatinginProduct();
	
	public boolean addRatingOfshopKeepers();
	
	public boolean chatStore(OnlineChatDetails chat);
	
	public boolean addProductInCart(OnlineProductDetails productDetail);
	
	public OnlineShopKeeper getAllShopKepperShopDetails();
	
	public OnlineUser logIn(String userName, String password);
	
	public boolean updatePassword(String question, String answer, String newPassword);
	
	public boolean updateSecurityQuestion(String preQuestion, String preAnswer, String newQuestion, String newAnswer);
	
	public List<RatingonProductStore> showAllRatingByUser(String userEmailId);
	
	public boolean SuggestChange(OnlineSuggestChangeProduct prod);
	
	
	
}
