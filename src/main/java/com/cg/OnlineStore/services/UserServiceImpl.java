package com.cg.OnlineStore.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductCart;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.dao.OnlineChatDetailsDao;
import com.cg.OnlineStore.dao.OnlineProductCartDao;
import com.cg.OnlineStore.dao.OnlineProductDetailsDao;
import com.cg.OnlineStore.dao.OnlineShopkeeperDao;
import com.cg.OnlineStore.dao.OnlineSuggestChangeOnProductDao;
import com.cg.OnlineStore.dao.OnlineUserDao;
import com.cg.OnlineStore.dao.RatingOnShopKeeperDao;
import com.cg.OnlineStore.dao.RatingonProductByShopKeeperDao;
import com.cg.OnlineStore.usedClasses.OnlineUserDashboardDetails;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private OnlineUserDao userDao;
	@Autowired
	private OnlineChatDetailsDao chatDao;
	@Autowired
	private OnlineShopkeeperDao shopkeeperDao;
	@Autowired
	private OnlineProductDetailsDao productDao;
	@Autowired
	private RatingonProductByShopKeeperDao ratingproductDao;
	@Autowired
	private RatingOnShopKeeperDao shopkeeperRatingDao;
	@Autowired
	private OnlineProductCartDao cartDao;
	@Autowired
	private OnlineSuggestChangeOnProductDao suggestDao;
	
	@Override
	public String isUserDtailsCorrect(String email, String MobileNumber) {
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
	public boolean registerUser(OnlineUser user) {
		userDao.save(user);
		return true;
	}


	@Override
	public OnlineUserDashboardDetails getUserDashboardDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OnlineProductDetails> getProductList() {
		return productDao.findAll();
	}

	@Override
	public boolean addRatinginProduct(RatingonProductStore prod) {
		OnlineProductDetails product = productDao.getById((long)prod.getProductName());
		double overAll = (product.getRating() + prod.getRating())/((double)product.getTotalRating()+1);
		product.setRating(overAll);
		product.setTotalRating(product.getTotalRating()+1);
		productDao.save(product);
		ratingproductDao.save(prod);
		return true;
	}

	@Override
	public boolean addRatingOfshopKeepers(RatingOnShopKeeper shop) {
		OnlineShopKeeper shopkeeper = shopkeeperDao.getById((long) shop.getShopkeeperId());
		double overall = (shopkeeper.getRating() + shop.getRating())/((double)shopkeeper.getTotalRating() + 1);
		shopkeeper.setRating(overall);
		shopkeeper.setTotalRating(shopkeeper.getTotalRating()+1);
		shopkeeperDao.save(shopkeeper);
		shopkeeperRatingDao.save(shop);
		return false;
	}


	@Override
	public String addProductInCart(OnlineProductCart productDetail) {
		OnlineProductCart prod = cartDao.getProductByProdId(productDetail.getProductID(), productDetail.getByUser());
		if(prod == null) {
			cartDao.save(productDetail);
			return "Success";
		}
		else {
			return "Product Already Added in your Cart!";
		}
	}

	@Override
	public List<OnlineShopKeeper> getAllShopKepperShopDetails() {
		return shopkeeperDao.findAll();
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
	public boolean changeSecurityQuestion(String email, String question, String answer) {
		if(email == null || question == null || answer == null) {
			return false;
		}
		shopkeeperDao.setNewSecurityQuestion(question, answer, email);
		return true;
	}


	@Override
	public List<RatingonProductStore> showAllRatingByUser(String userEmailId) {
		return ratingproductDao.findByRatingBy(userEmailId);
	}

	@Override
	public boolean SuggestChange(OnlineSuggestChangeProduct prod) {
		suggestDao.save(prod);
		return true;
	}

	@Override
	public String checkSecurityQuestionDetails(String Username, String question, String answer) {
		OnlineUser shop = userDao.findByEmailId(Username);
		if(shop == null) {
			return "No User Exist with entered MailID !";
		}
		if(shop.getSecurityQuestion().equals(question)) {
			if(shop.getSecurityAnswer().equals(answer)) {
				return "success !";
			}else {
				return "Entered Security Answer is wrong!";
			}
		}else {
			return "Entered Security Question is wrong";
		}
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
	public List<OnlineChatDetails> getChat(String user1, String user2) {
		return chatDao.getOnlineChat(user1, user2);
	}

	@Override
	public boolean storeChat(OnlineChatDetails ch) {
		chatDao.save(ch);
		return true;
	}

	@Override
	public boolean deleteProductInCart(int prodId, String userName) {
		OnlineProductCart cart = cartDao.getProductByProdId(prodId, userName);
		cartDao.deleteById((long)cart.getProductID());
		return true;
	}

	@Override
	public List<OnlineProductCart> getAllProdInCart(String userName) {
		return cartDao.findByByUser(userName);
	}

	@Override
	public List<RatingOnShopKeeper> showAllRatingOnShopKeeperByUser(int Id) {
		shopkeeperRatingDao.findByCustomerUserName(Id);
		return null;
	}

	@Override
	public boolean deleteRatingOnProduct(int prodId) {
		RatingonProductStore rating = ratingproductDao.getById((long)prodId);
		OnlineProductDetails prod = productDao.getById((long)rating.getProductName());
		double temp = (prod.getRating()*prod.getTotalRating() - rating.getRating()) / ((double)prod.getTotalRating() - 1);
		prod.setRating(temp);
		prod.setTotalRating(prod.getTotalRating() - 1);
		productDao.save(prod);
		ratingproductDao.deleteById((long)prodId);
		return true;
	}

	@Override
	public List<OnlineSuggestChangeProduct> getByUserName(String user) {
		return suggestDao.findByByUserId(user);
	}
	
	

}
