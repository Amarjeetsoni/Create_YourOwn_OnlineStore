package com.cg.OnlineStore.services;

import java.util.List;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

public class UserServiceImpl implements UserServices {

	@Override
	public boolean isUserDtailsCorrect(OnlineUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerUser(OnlineUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OnlineUser getUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnlineUserDashboardDetails getUserDashboardDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OnlineProductDetails> getProductDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRatinginProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addRatingOfshopKeepers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean chatStore(OnlineChatDetails chat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProductInCart(OnlineProductDetails productDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OnlineShopKeeper getAllShopKepperShopDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
