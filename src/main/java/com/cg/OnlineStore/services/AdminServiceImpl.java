package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineAdminRole;
import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductByShopKeeper;
import com.cg.OnlineStore.usedClasses.OnlineAdminDashboardDetails;

public class AdminServiceImpl implements AdminService {

	@Override
	public OnlineAdminRole Login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean varifySecurityQuestion(String question, String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeSecurityQuestion(String question, String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OnlineAdminDashboardDetails getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveShopkeeper(OnlineShopKeeper shop) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OnlineShopKeeper> viewAllShopKeeper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OnlineUser> viewAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean suspendUserAccount(int days) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suspendShopkeeprAccount(int days) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storeChat(OnlineChatDetails chat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RatingonProductByShopKeeper> getListOfRatingOnProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RatingOnShopKeeper> getListOfRatingOnShopKeeper() {
		// TODO Auto-generated method stub
		return null;
	}

}
