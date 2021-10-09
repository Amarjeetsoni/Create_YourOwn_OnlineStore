package com.cg.OnlineStore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeOnProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingonProductByShopKeeper;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

@Service
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

	@Override
	public OnlineUser logIn(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePassword(String question, String answer, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSecurityQuestion(String preQuestion, String preAnswer, String newQuestion, String newAnswer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RatingonProductByShopKeeper> showAllRatingByUser(String userEmailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean SuggestChange(OnlineSuggestChangeOnProduct prod) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
