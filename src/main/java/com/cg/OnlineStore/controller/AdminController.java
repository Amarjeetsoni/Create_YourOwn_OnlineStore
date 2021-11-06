package com.cg.OnlineStore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineStore.Entity.OnlineAdminRole;
import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineNotification;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.services.AdminService;

@SpringBootApplication
@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginDetails(@RequestBody GetUserNamePassword detail){
		OnlineAdminRole user = adminService.Login(detail.email, detail.password);
		if(user == null) {
			return new ResponseEntity<Object>("UserName/Password is wrong!", HttpStatus.UNAUTHORIZED);
		}
		else {
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
	}
	
	@PostMapping("/updatepassword")
	public ResponseEntity<Object> UpdatePassword(@RequestBody UsernamePassword user){
		boolean temp = adminService.changePassword(user.email, user.password);
		if(temp) {
			return new ResponseEntity<Object> ("Password Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object> ("Something wents wrong !", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/validateSecurity")
	public ResponseEntity<Object> CheckSecurityQuestionDetail(@RequestBody CheckSecurityQuestion security){
		String str = adminService.varifySecurityQuestion(security.UserName, security.question, security.answer);
		if(str.equals("success !")) {
			return new ResponseEntity<Object>(str, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(str, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/changeSequrityQuestion")
	public ResponseEntity<Object> ChangeSecurityQuestion(@RequestBody SecurityQuestion user){
		boolean temp = adminService.changeSecurityQuestion(user.email, user.question, user.answer);
		if(temp) {
			return new ResponseEntity<Object>("Details Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Someting wents wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/approveShopRating")
	public ResponseEntity<Object> ApproveShopKeeper(@RequestParam("shopkeeperId") long id){
		if(adminService.approveShopkeeper(id)) {
			return new ResponseEntity<Object>("Aproved Shopkeeper account successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllpending")
	public ResponseEntity<Object> getAllpendingApproval(){
		List<OnlineShopKeeper> shop = adminService.getListofPendingRequest();
		if(shop.isEmpty()) {
			return new ResponseEntity<Object>("No New Account is created during this time!", HttpStatus.NO_CONTENT);
		}
		else {
			List<SendShopKeeperId> temp = new ArrayList<SendShopKeeperId>();
			for(OnlineShopKeeper sh: shop) {
				SendShopKeeperId send = new SendShopKeeperId(sh.getShopId(), sh.getShopKeeperUserName(), sh.getEmailId(), sh.getNameOfShop(), sh.getAddress(), sh.getShopType());
				temp.add(send);
			}
			return new ResponseEntity<Object>(temp, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllShop")
	public ResponseEntity<Object> getAllshopKeeper(){
		List<OnlineShopKeeper> getAll = adminService.viewAllShopKeeper();
		if(getAll.isEmpty()) {
			return new ResponseEntity<Object>("No ShopKeeper is registered Yet!", HttpStatus.NO_CONTENT);
		}
		else {
			List<SendShopKeeperDetail> shop = new ArrayList<>();
			for(OnlineShopKeeper sh: getAll) {
				if(sh.isActive() && sh.isApproved()) {
				SendShopKeeperDetail temp = new SendShopKeeperDetail(sh.getShopKeeperUserName(), sh.getTotalProductAdded(), sh.getEmailId(), sh.getNameOfShop(), sh.getAddress(), sh.getShopType(), sh.getRating(), sh.getTotalRating());
				shop.add(temp);
			}
			}
			if(shop.isEmpty()) {
				return new ResponseEntity<Object>("No Shop is approved yet!, Wait until admin approves it", HttpStatus.OK);
			}
			return new ResponseEntity<Object>(shop, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<Object> getAllUser(){
		List<OnlineUser> user = adminService.viewAllUser();
		if(user.isEmpty()) {
			return new ResponseEntity<Object>("No User Founded on the Site Yet!", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getchat")
	public ResponseEntity<Object> getChat(@RequestParam("user1") String user1, @RequestParam("user2") String user2){
		List<OnlineChatDetails> listchat = adminService.getChat(user1, user2);
		if(listchat.isEmpty()) {
			return new ResponseEntity<Object>("No Chat Founded !", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(listchat, HttpStatus.OK);
		}
	}
	
	@PostMapping("/saveChat")
	public ResponseEntity<Object> SaveChat(@RequestBody OnlineChat chat){
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
		String strDate = dateFormat.format(date);
		OnlineChatDetails chatto = new OnlineChatDetails(chat.from, chat.to, chat.message, strDate);
		if(adminService.storeChat(chatto)) {
			return new ResponseEntity<Object>("Saved Successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something Wents wrong!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllproductList")
	public ResponseEntity<Object> getAllPRoductList(){
		List<OnlineProductDetails> prod = adminService.getProductList();
		if(prod.isEmpty()) {
			return new ResponseEntity<Object>("No Product Details Available!", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(prod, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<Object> deleteProduct(@RequestParam("id") int id){
		if(adminService.deleteProduct(id)) {
			return new ResponseEntity<Object>("Product Deleted successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents Wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/addNotification")
	public ResponseEntity<Object> addNotification(@RequestBody Notification not){
		OnlineNotification noti = new OnlineNotification(not.fromUser, not.toUser, not.messageVal);
		if(adminService.addNotification(noti)){
			return new ResponseEntity<Object>("Notification added successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/deleteNotification")
	public ResponseEntity<Object> deleteNotification(@RequestParam("id") long Id){
		if(adminService.deleteNotification(Id)) {
			return new ResponseEntity<Object>("Notification Deleted successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
}

class Notification{
	public String fromUser;
	public String toUser;
	public String messageVal;
}

class SendShopKeeperId{
	public int shopKeeperId;
	public String shopKeeperUserName;
	public String emailId;
	public String nameOfShop;
	public String Address;
	public String shopType;
	public SendShopKeeperId(int shopKeeperId, String shopKeeperUserName, String emailId, String nameOfShop,
			String address, String shopType) {
		this.shopKeeperId = shopKeeperId;
		this.shopKeeperUserName = shopKeeperUserName;
		this.emailId = emailId;
		this.nameOfShop = nameOfShop;
		Address = address;
		this.shopType = shopType;
	
	}
	
}

