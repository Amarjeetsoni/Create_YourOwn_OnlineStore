package com.cg.OnlineStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.dao.OnlineChatDetailsDao;
import com.cg.OnlineStore.dao.OnlineProductDetailsDao;
import com.cg.OnlineStore.dao.OnlineShopkeeperDao;
import com.cg.OnlineStore.dao.OnlineSuggestChangeOnProductDao;
import com.cg.OnlineStore.dao.OnlineUserDao;
import com.cg.OnlineStore.dao.RatingOnShopKeeperDao;
import com.cg.OnlineStore.dao.RatingonProductByShopKeeperDao;
import com.cg.OnlineStore.usedClasses.OnlineShopKeeperDashboardDetails;

@Service
public class ShopKeeperServiceImpl implements ShopkeeperServices {

	@Autowired
	private OnlineUserDao userDao;
	@Autowired
	private OnlineShopkeeperDao shopkeeperDao;
	@Autowired
	private OnlineProductDetailsDao productDao;
	@Autowired
	private OnlineChatDetailsDao chatDao;
	@Autowired
	private OnlineSuggestChangeOnProductDao changeDao;
	@Autowired 
	private RatingonProductByShopKeeperDao ratingDao;
	@Autowired
	private RatingOnShopKeeperDao shopRatingDao;
	
	@Override
	public String checkDetail(String email, String MobileNumber) {
		List<OnlineUser> allUser = userDao.findAll();
		List<OnlineShopKeeper> allShopKeeper = shopkeeperDao.findAll();
		long checkMobileShop = allShopKeeper.stream().filter(t->t.getMobileNumber().equals(MobileNumber)).count();
		long checkMailShop = allShopKeeper.stream().filter(t->t.getEmailId().equals(email)).count();
		long checkMail = allUser.stream().filter(t->t.getEmailId().equals(email)).count();
		long checkNumber = allUser.stream().filter(t->t.getMobileNumber().equals(MobileNumber)).count();
		if((checkMail > 0 && checkNumber > 0) || (checkMobileShop > 0 && checkMailShop > 0)) {
			return "Email Id and Mobile Number both are Already Exist";
		}
		else if(checkMail > 0 || checkMailShop > 0) {
			return "Email Id Already exists";
		}
		else if(checkNumber > 0 || checkMobileShop > 0) {
			return "Mobile Number Already Exists";
		}
		else {
			return "success";
		}
	}

	@Override
	public boolean registerShop(OnlineShopKeeper shopDetail) {
		shopkeeperDao.save(shopDetail);
		return true;
	}

	@Override
	public boolean changePassword(String userName, String password) {
		if(password.equals("") || password == null) {
			return false;
		}
		shopkeeperDao.setUserPasswordByemail(password, userName);
		return true;
	}

	@Override
	public boolean changeSecurityQuestion(String email, String question, String answer) {
		if(email == null || question == null || answer == null) {
			return false;
		}
		shopkeeperDao.setNewSecurityQuestion(question, answer, email);
		return true;
	}

	@Override
	public OnlineShopKeeper login(String userName, String password) {
		OnlineShopKeeper shop = shopkeeperDao.findByemailId(userName);
		if(shop == null) {
			return null;
		}
		if(shop.getShopKeeperPassword().equals(password)) {
			return shop;
		}
		else {
			return null;
		}
	}

	@Override
	public OnlineShopKeeperDashboardDetails getDetails() {
		return null;
	}

	@Override
	public boolean addProduct(OnlineProductDetails product) {
		productDao.save(product);
		return true;
		
	}

	@Override
	public List<OnlineProductDetails> getProductList(String UserName) {
		return productDao.findByAddedByUserName(UserName);
	}

	@Override
	public boolean updateProductDetail(OnlineProductDetails product) {
		productDao.save(product);
		return true;
	}

	@Override
	public boolean deleteProductDetail(long id) {
		productDao.deleteById(id);
		return true;
	}

	@Override
	public boolean storeChat(OnlineChatDetails ch) {
		chatDao.save(ch);
		return true;
	}

	@Override
	public List<OnlineSuggestChangeProduct> seeAllSuggestion(String name) {
	    return changeDao.findByToShopKeeper(name);
	}

	@Override
	public List<RatingonProductStore> getAllratingOnProduct(String userName) {
		return ratingDao.findByAddedByShopKeeper(userName);
	}

	@Override
	public List<RatingOnShopKeeper> getAllShopRating(int Id) {
		return shopRatingDao.findByCustomerUserName(Id);
	}

	@Override
	public List<OnlineShopKeeper> getListOfShopKeeper() {
		return shopkeeperDao.findAll();
	}

	@Override
	public boolean giveSuggestionToAdmin(String from, String message) {
		
		return false;
	}

	@Override
	public String checkSecurityQuestionDetails(String Username, String question, String answer) {
		OnlineShopKeeper shop = shopkeeperDao.findByemailId(Username);
		if(shop == null) {
			return "No User Exist with entered MailID !";
		}
		if(shop.getSecurityQuestion().equals(question)) {
			if(shop.getAnswer().equals(answer)) {
				return "success !";
			}else {
				return "Entered Security Answer is wrong!";
			}
		}else {
			return "Entered Security Question is wrong";
		}
	}

	@Override
	public List<OnlineProductDetails> getAllProduct() {
		return productDao.findAll();
	}

	@Override
	public List<OnlineChatDetails> getChat(String user1, String user2) {
		return chatDao.getOnlineChat(user1, user2);
		
	}

	@Override
	public boolean takeActionOnSuggestion(long suggestionId, boolean isAccepted, String comment) {
		OnlineSuggestChangeProduct suggestion = changeDao.getById(suggestionId);
		suggestion.setAccepted(isAccepted);
		suggestion.setCommentShopKeeper(comment);
		changeDao.save(suggestion);
		return true;
	}

	@Override
	public List<RatingonProductStore> getRatingByProductName(int id) {
		return ratingDao.findByProductName(id);
	}

}
