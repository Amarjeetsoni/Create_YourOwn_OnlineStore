package com.cg.OnlineStore.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeOnProduct;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductByShopKeeper;
import com.cg.OnlineStore.usedClasses.OnlineShopKeeperDashboardDetails;

@Service
public class ShopKeeperServiceImpl implements ShopkeeperServices {

	@Override
	public boolean checkDetail(OnlineShopKeeper shopKeeper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerShop(OnlineShopKeeper shopDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeSecurityQuestion(String question, String answer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OnlineShopKeeper login(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnlineShopKeeperDashboardDetails getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(OnlineProductDetails product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OnlineProductDetails> getProductList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProductDetail(OnlineProductDetails product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductDetail(OnlineProductDetails product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean storeChat(OnlineChatDetails ch) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean seeSuggestion(OnlineSuggestChangeOnProduct product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RatingonProductByShopKeeper> getAllrating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RatingOnShopKeeper> getAllShopRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OnlineShopKeeper> getListOfShopKeeper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean giveSuggestionToAdmin(String message) {
		// TODO Auto-generated method stub
		return false;
	}

}
