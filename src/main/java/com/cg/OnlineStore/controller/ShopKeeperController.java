package com.cg.OnlineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.services.ShopkeeperServices;

@SpringBootApplication
@RestController
@CrossOrigin("*")
@RequestMapping("/shopkeeper")
public class ShopKeeperController {
	@Autowired
	private ShopkeeperServices shopKeeper;
	
	
	@RequestMapping(value="/checkDetail")
	public ResponseEntity<Object> checkDetails(@RequestBody CheckUserDetails userDetail){
		String str = shopKeeper.checkDetail(userDetail.emailId, userDetail.mobileNumber);
		if(str.equals("success")) {
			return new ResponseEntity<Object>("Accepted", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(str,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveShopkeeper")
	public ResponseEntity<Object> saveShopkeeperDetail(@RequestBody OnlineShopkeeperDetail shopkeeperdetail){
		OnlineShopKeeper shopkeeper = new OnlineShopKeeper(shopkeeperdetail.shopKeeperUserName, shopkeeperdetail.shopKeeperPassword, shopkeeperdetail.totalProductAdded, shopkeeperdetail.emailId, shopkeeperdetail.mobileNumber, shopkeeperdetail.nameOfShop, shopkeeperdetail.Address, shopkeeperdetail.shopType, 0.0, false, false, shopkeeperdetail.securityQuestion, shopkeeperdetail.answer);
		shopKeeper.registerShop(shopkeeper);
		return new ResponseEntity<Object> ("New Shop details Request Has been Sent to Admin. Please wait while admin approves it!", HttpStatus.OK);
	}
	
	@PostMapping("/validateSecurity")
	public ResponseEntity<Object> CheckSecurityQuestionDetail(@RequestBody CheckSecurityQuestion security){
		String str = shopKeeper.checkSecurityQuestionDetails(security.UserName, security.question, security.answer);
		if(str.equals("success !")) {
			return new ResponseEntity<Object>(str, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(str, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updatepassword")
	public ResponseEntity<Object> UpdatePassword(@RequestBody UsernamePassword user){
		boolean temp = shopKeeper.changePassword(user.email, user.password);
		if(temp) {
			return new ResponseEntity<Object> ("Password Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object> ("Something wents wrong !", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/updateSecurityQuestion")
	public ResponseEntity<Object> UpdateQuestion(@RequestBody SecurityQuestion user){
		boolean temp = shopKeeper.changeSecurityQuestion(user.email, user.question, user.answer);
		if(temp) {
			return new ResponseEntity<Object>("Details Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Someting wents wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
	
}

class OnlineShopkeeperDetail{
	public String shopKeeperUserName;
	public String shopKeeperPassword;
	public int totalProductAdded;
	public String emailId;
	public String mobileNumber;
	public String nameOfShop;
	public String Address;
	public String shopType;
	public double rating;
	public boolean isApproved;
	public boolean isActive;
	public String securityQuestion;
	public String answer;
}

class CheckSecurityQuestion{
	public String UserName;
	public String question;
	public String answer;
}

class UsernamePassword{
	public String email;
	public String password;
}

class SecurityQuestion{
	public String email;
	public String question;
	public String answer;
}