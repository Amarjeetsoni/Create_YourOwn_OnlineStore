package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.usedClasses.OnlineShopKeeperDashboardDetails;

public interface ShopkeeperServices {

	public String checkDetail(String email, String mobileNumber);
	
	public boolean registerShop(OnlineShopKeeper shopDetail);
	
	public String checkSecurityQuestionDetails(String UserName, String question, String answer);
	
	public boolean changePassword(String userName, String password);
	
	public boolean changeSecurityQuestion(String email, String question, String answer);
	
	public OnlineShopKeeper login(String userName, String password);
	
	public OnlineShopKeeperDashboardDetails getDetails();
	
	public boolean addProduct(OnlineProductDetails product);
	
	public List<OnlineProductDetails> getProductList(String username);
	
	public boolean updateProductDetail(OnlineProductDetails product);
	
	public boolean deleteProductDetail(long Id);
	
	public boolean storeChat(OnlineChatDetails ch);
	
	public List<OnlineChatDetails> getChat(String user1, String user2);
	
	public List<OnlineSuggestChangeProduct> seeAllSuggestion(String name);
	
	public boolean takeActionOnSuggestion(long suggestionId, boolean isAccepted, String comment);
	
	public List<RatingonProductStore> getAllratingOnProduct(String name);
	
	public List<RatingOnShopKeeper> getAllShopRating(int id);
	
	public List<RatingonProductStore> getRatingByProductName(int id);
	
	public List<OnlineShopKeeper> getListOfShopKeeper();
	
	public boolean giveSuggestionToAdmin(String userName, String message);
	
	public List<OnlineProductDetails> getAllProduct();
	
}
