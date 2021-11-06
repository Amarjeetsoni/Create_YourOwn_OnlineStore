package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductCart;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

public interface UserServices {

	public String isUserDtailsCorrect(String email, String mobileNumber);
	
	public boolean registerUser(OnlineUser user);
	
	public String checkSecurityQuestionDetails(String UserName, String question, String answer);
	
	public boolean changePassword(String userName, String password);
	
	public boolean changeSecurityQuestion(String email, String question, String answer);
	
	public OnlineUserDashboardDetails getUserDashboardDetails();
	
	public List<OnlineProductDetails> getProductList();
	
	public boolean addRatinginProduct(RatingonProductStore prod);
	
	public boolean deleteRatingOnProduct(int prodId);
	
	public boolean addRatingOfshopKeepers(RatingOnShopKeeper shop);
	
	public List<OnlineChatDetails> getChat(String user1, String user2);
	
	public boolean storeChat(OnlineChatDetails ch);
	
	public String addProductInCart(OnlineProductCart productDetail);
	
	public boolean deleteProductInCart(int prodId, String userName);
	
	public List<OnlineProductCart> getAllProdInCart(String userName);
	
	public List<OnlineShopKeeper> getAllShopKepperShopDetails();
	
	public OnlineUser logIn(String userName, String password);
	
	public List<RatingonProductStore> showAllRatingByUser(String userEmailId);
	
	public List<RatingOnShopKeeper> showAllRatingOnShopKeeperByUser(int Id);
	
	public boolean SuggestChange(OnlineSuggestChangeProduct prod);
	
	public List<OnlineSuggestChangeProduct> getByUserName(String user);
	
	
	
}
