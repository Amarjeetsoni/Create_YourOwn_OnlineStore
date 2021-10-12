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

	public boolean checkDetail(OnlineShopKeeper shopKeeper);
	
	public boolean registerShop(OnlineShopKeeper shopDetail);
	
	public boolean changePassword(String userName, String password);
	
	public boolean changeSecurityQuestion(String question, String answer);
	
	public OnlineShopKeeper login(String userName, String password);
	
	public OnlineShopKeeperDashboardDetails getDetails();
	
	public boolean addProduct(OnlineProductDetails product);
	
	public List<OnlineProductDetails> getProductList();
	
	public boolean updateProductDetail(OnlineProductDetails product);
	
	public boolean deleteProductDetail(OnlineProductDetails product);
	
	public boolean storeChat(OnlineChatDetails ch);
	
	public boolean seeSuggestion(OnlineSuggestChangeProduct product);
	
	public List<RatingonProductStore> getAllrating();
	
	public List<RatingOnShopKeeper> getAllShopRating();
	
	public List<OnlineShopKeeper> getListOfShopKeeper();
	
	public boolean giveSuggestionToAdmin(String message);
	
}
