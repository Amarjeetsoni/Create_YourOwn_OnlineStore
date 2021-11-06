package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineAdminRole;
import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineNotification;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.usedClasses.OnlineAdminDashboardDetails;

public interface AdminService {
	
	public OnlineAdminRole Login(String userName, String password);
	
	public boolean changePassword(String userName, String password);
	
	public String varifySecurityQuestion(String Username, String question, String answer);
	
	public boolean changeSecurityQuestion(String email, String question, String answer);
	
	public OnlineAdminDashboardDetails getDetails();
	
	public boolean approveShopkeeper(long shopKeeperId);
	
	public List<OnlineShopKeeper> getListofPendingRequest();
	
	public List<OnlineShopKeeper> viewAllShopKeeper();
	
	public List<OnlineUser> viewAllUser();
	
	public boolean suspendUserAccount(int days);
	
	public boolean suspendShopkeeprAccount(int days);
	
	public boolean storeChat(OnlineChatDetails chat);
	
	public List<OnlineChatDetails> getChat(String user1, String user2);
	
	public List<OnlineProductDetails> getProductList();
	
	public boolean deleteProduct(long id);
	
	public List<RatingonProductStore> getListOfRatingOnProduct();
	
	public List<RatingOnShopKeeper> getListOfRatingOnShopKeeper();
	
	public boolean addNotification(OnlineNotification not);
	
	public boolean deleteNotification(long notId);
	
	public List<OnlineNotification> getNotification(String userName);

}
