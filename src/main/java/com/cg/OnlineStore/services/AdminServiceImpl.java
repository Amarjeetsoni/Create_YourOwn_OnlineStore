package com.cg.OnlineStore.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.OnlineStore.Entity.OnlineAdminRole;
import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineNotification;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.dao.OnlineAdminDao;
import com.cg.OnlineStore.dao.OnlineChatDetailsDao;
import com.cg.OnlineStore.dao.OnlineNotificationDao;
import com.cg.OnlineStore.dao.OnlineProductDetailsDao;
import com.cg.OnlineStore.dao.OnlineShopkeeperDao;
import com.cg.OnlineStore.dao.OnlineUserDao;
import com.cg.OnlineStore.usedClasses.OnlineAdminDashboardDetails;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private OnlineProductDetailsDao productDao;
	@Autowired
	OnlineAdminDao adminDao;
	@Autowired
	private OnlineShopkeeperDao shopkeeperDao;
	@Autowired
	private OnlineUserDao userDao;
	@Autowired
	private OnlineChatDetailsDao chatDao;
	@Autowired
	private OnlineNotificationDao notificationDao;
	
	
	@Override
	public OnlineAdminRole Login(String userName, String password) {
		OnlineAdminRole allUser = adminDao.findByUserName(userName);
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
	public boolean changePassword(String userName, String password) {
		if(password.equals("") || password == null) {
			return false;
		}
		adminDao.setUserPasswordByemail(password, userName);
		return true;
	}

	@Override
	public String varifySecurityQuestion(String Username, String question, String answer) {
		OnlineAdminRole shop = adminDao.findByUserName(Username);
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
	public boolean changeSecurityQuestion(String email, String question, String answer) {
		if(email == null || question == null || answer == null) {
			return false;
		}
		adminDao.setNewSecurityQuestion(question, answer, email);
		return true;
	}

	@Override
	public OnlineAdminDashboardDetails getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approveShopkeeper(long shop) {
		OnlineShopKeeper sh = shopkeeperDao.getById(shop);
		sh.setApproved(true);
		sh.setActive(true);
		shopkeeperDao.save(sh);
		return true;
	}

	
	@Override
	public List<OnlineShopKeeper> viewAllShopKeeper() {
		return shopkeeperDao.findAll();
	}

	@Override
	public List<OnlineUser> viewAllUser() {
		return userDao.findAll();
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
	public List<OnlineChatDetails> getChat(String user1, String user2) {
		return chatDao.getOnlineChat(user1, user2);
	}

	@Override
	public boolean storeChat(OnlineChatDetails ch) {
		chatDao.save(ch);
		return true;
	}
	
	

	@Override
	public List<RatingonProductStore> getListOfRatingOnProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RatingOnShopKeeper> getListOfRatingOnShopKeeper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OnlineShopKeeper> getListofPendingRequest() {
		List<OnlineShopKeeper> listshop = shopkeeperDao.findAll();
		if(listshop.isEmpty()) {
			return null;
		}
		listshop = listshop.stream().filter(t->t.isApproved() == false).collect(Collectors.toList());
		return listshop;
	}

	@Override
	public List<OnlineProductDetails> getProductList() {
		return productDao.findAll();
	}

	@Override
	public boolean deleteProduct(long id) {
		productDao.deleteById(id);
		return true;
	}

	@Override
	public boolean addNotification(OnlineNotification not) {
		notificationDao.save(not);
		return true;
	}

	@Override
	public boolean deleteNotification(long notId) {
		notificationDao.deleteById(notId);
		return true;
	}

	@Override
	public List<OnlineNotification> getNotification(String userName) {
		return notificationDao.findByToUser(userName);
	}

}
