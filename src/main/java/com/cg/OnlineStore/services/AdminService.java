package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineAdminRole;
import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductByShopKeeper;
import com.cg.OnlineStore.usedClasses.OnlineAdminDashboardDetails;

public interface AdminService {
	
	public OnlineAdminRole Login(String userName, String password);
	
	public boolean changePassword(String userName, String password);
	
	public boolean varifySecurityQuestion(String question, String answer);
	
	public boolean changeSecurityQuestion(String question, String answer);
	
	public OnlineAdminDashboardDetails getDetails();
	
	public boolean approveShopkeeper(OnlineShopKeeper shop);
	
	public List<OnlineShopKeeper> viewAllShopKeeper();
	
	public List<OnlineUser> viewAllUser();
	
	public boolean suspendUserAccount(int days);
	
	public boolean suspendShopkeeprAccount(int days);
	
	public boolean storeChat(OnlineChatDetails chat);
	
	public List<RatingonProductByShopKeeper> getListOfRatingOnProduct();
	
	public List<RatingOnShopKeeper> getListOfRatingOnShopKeeper();
	
	

}
