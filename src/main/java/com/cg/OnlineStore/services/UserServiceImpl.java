package com.cg.OnlineStore.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.dao.OnlineUserDao;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private OnlineUserDao userDao;
	
	@Override
	public String isUserDtailsCorrect(String email, String MobileNumber) {
		List<OnlineUser> allUser = userDao.findAll();
		long checkMail = allUser.stream().filter(t->t.getEmailId().equals(email)).count();
		long checkNumber = allUser.stream().filter(t->t.getMobileNumber().equals(MobileNumber)).count();
		if(checkMail > 0 && checkNumber > 0) {
			return "Email Id and Mobile Number both are Already Exist";
		}
		else if(checkMail > 0) {
			return "Email Id Already exists";
		}
		else if(checkNumber > 0) {
			return "Mobile Number Already Exists";
		}
		else {
			return "success";
		}
	}

	@Override
	public boolean registerUser(OnlineUser user) {
		userDao.save(user);
		return true;
	}

	@Override
	public OnlineUser getUserDetails(String emailId) {
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
		OnlineUser allUser = userDao.findByEmailId(userName);
		if(allUser == null) {
			return null;
		}
		else {
			if(allUser.getPassword().equals(password)) {
				return allUser;
			}
			else {
				return null;
			}
		}
		
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
	public List<RatingonProductStore> showAllRatingByUser(String userEmailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean SuggestChange(OnlineSuggestChangeProduct prod) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
