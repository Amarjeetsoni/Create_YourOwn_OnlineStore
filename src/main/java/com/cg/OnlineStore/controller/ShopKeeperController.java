package com.cg.OnlineStore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
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
		String str = shopKeeper.checkDetail(shopkeeperdetail.emailId, shopkeeperdetail.mobileNumber);
		if(str.equals("success")) {
		OnlineShopKeeper shopkeeper = new OnlineShopKeeper(shopkeeperdetail.shopKeeperUserName, shopkeeperdetail.shopKeeperPassword, shopkeeperdetail.totalProductAdded, shopkeeperdetail.emailId, shopkeeperdetail.mobileNumber, shopkeeperdetail.nameOfShop, shopkeeperdetail.Address, shopkeeperdetail.shopType, 0.0, false, false, shopkeeperdetail.securityQuestion, shopkeeperdetail.answer, 0);
		shopKeeper.registerShop(shopkeeper);
		return new ResponseEntity<Object> ("New Shop details Request Has been Sent to Admin. Please wait while admin approves it!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(str,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/validateSecurity")
	public ResponseEntity<Object> CheckSecurityQuestionDetail(@RequestBody CheckSecurityQuestion security){
		String str = shopKeeper.checkSecurityQuestionDetails(security.UserName, security.question, security.answer);
		if(str.equals("success !")) {
			return new ResponseEntity<Object>(str, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(str, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/updatepassword")
	public ResponseEntity<Object> UpdatePassword(@RequestBody UsernamePassword user){
		boolean temp = shopKeeper.changePassword(user.email, user.password);
		if(temp) {
			return new ResponseEntity<Object> ("Password Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object> ("Something wents wrong !", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/updateSecurityQuestion")
	public ResponseEntity<Object> UpdateQuestion(@RequestBody SecurityQuestion user){
		boolean temp = shopKeeper.changeSecurityQuestion(user.email, user.question, user.answer);
		if(temp) {
			return new ResponseEntity<Object>("Details Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Someting wents wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> Login(@RequestBody UsernamePassword user){
		OnlineShopKeeper detail = shopKeeper.login(user.email, user.password);
		if(detail == null) {
			return new ResponseEntity<Object>("UserName or Password is Wrong", HttpStatus.BAD_REQUEST);
		}
		else {

			if(detail.isApproved()) {
				return new ResponseEntity<Object>(detail, HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("Your Request is still pending with the Admin...Once He will approve then only you can login...Please cooprate with us untill then.", HttpStatus.OK);
			}
		}
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<Object> addProduct(@RequestBody ProductDetail detail){
		OnlineProductDetails prod = new OnlineProductDetails(detail.productName, detail.price, detail.category, detail.imageLink, detail.description, 0.0, detail.addedByUserName, 0);
		shopKeeper.addProduct(prod);
		return new ResponseEntity<Object>("Product Detail Save Successfully!", HttpStatus.OK);
	}
	
	@GetMapping("/getProductList")
	public ResponseEntity<Object> getListProduct(@RequestParam("username") String user){
		List<OnlineProductDetails> prodList = shopKeeper.getProductList(user);
		if(prodList.size() == 0) {
			return new ResponseEntity<Object>("No Product Added By you in your Shop!", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(prodList, HttpStatus.OK);
		}
	}
	
	@GetMapping("/gettAllProduct")
	public ResponseEntity<Object> getAllproductList(){
		List<OnlineProductDetails> prodList = shopKeeper.getAllProduct();
		if(prodList.size() == 0) {
			return new ResponseEntity<Object>("No Product Available till now Please add some !!", HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Object>(prodList, HttpStatus.OK);
		}
	}
	
	@PutMapping("/UpdateProduct")
	public ResponseEntity<Object> updateProduct(@RequestBody OnlineProductDetails prod){
		if(shopKeeper.updateProductDetail(prod)) {
			return new ResponseEntity<Object>("Updated SuccessFully!!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something Wents wrong!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<Object> deleteProduct(@RequestParam("Id") long id){
		if(shopKeeper.deleteProductDetail(id)) {
			return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents Wrong!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveChat")
	public ResponseEntity<Object> SaveChat(@RequestBody OnlineChat chat){
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
		String strDate = dateFormat.format(date);
		OnlineChatDetails chatto = new OnlineChatDetails(chat.from, chat.to, chat.message, strDate);
		if(shopKeeper.storeChat(chatto)) {
			return new ResponseEntity<Object>("Saved Successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something Wents wrong!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getchat")
	public ResponseEntity<Object> getChat(@RequestParam("user1") String user1, @RequestParam("user2") String user2){
		List<OnlineChatDetails> listchat = shopKeeper.getChat(user1, user2);
		if(listchat.isEmpty()) {
			return new ResponseEntity<Object>("No Chat Founded !", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(listchat, HttpStatus.OK);
		}
	}
	
	@PostMapping("/getAllSuggestion")
	public ResponseEntity<Object> getSuggestions(@RequestBody GetUserName name){
		List<OnlineSuggestChangeProduct> detail = shopKeeper.seeAllSuggestion(name.username);
		if(detail.isEmpty()) {
			return new ResponseEntity<Object>("No Suggestion Available Right Now ! Please add some more product!", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(detail, HttpStatus.OK);
		}
	}
	
	@PostMapping("/actionOnRequest")
	public ResponseEntity<Object> actionOnSuggestion(@RequestBody GetDetail detail){
		if(shopKeeper.takeActionOnSuggestion(detail.suggestionId, detail.isAccepted, detail.comment)) {
			return new ResponseEntity<Object>("Suggestion Action Completed !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents Wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/getAllproductRating")
	public ResponseEntity<Object> getAllRating(@RequestBody GetUserName user){
		List<RatingonProductStore> ratings = shopKeeper.getAllratingOnProduct(user.username);
		if(ratings.isEmpty()) {
			return new ResponseEntity<Object>("No Rating is received On any Product Yet.", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(ratings, HttpStatus.OK);
		}
	}
	
	@PostMapping("/getRatingOnProduct")
	public ResponseEntity<Object> getRatingByProductName(@RequestParam("Id") int id){
		List<RatingonProductStore> ratings = shopKeeper.getRatingByProductName(id);
		if(ratings.isEmpty()) {
			return new ResponseEntity<Object>("No Rating is there on Selected Product!",HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(ratings, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getRatingShopKeeper")
	public ResponseEntity<Object> getRatingOnShopKeeperById(@RequestParam("Id") int id){
		List<RatingOnShopKeeper> rating = shopKeeper.getAllShopRating(id);
		if(rating.isEmpty()) {
			return new ResponseEntity<Object>("No Rating is there on Selected ShopKeeper!",HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(rating, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getListofShopkeeper")
	public ResponseEntity<Object> getShopKeeperList(){
		List<OnlineShopKeeper> detail = shopKeeper.getListOfShopKeeper();
		if(detail.isEmpty()) {
			return new ResponseEntity<Object>("No ShopKeeper founded yet!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(detail, HttpStatus.OK);
		}
	}
	
	@PostMapping("/suggestAdmin")
	public ResponseEntity<Object> suggestAdmin(@RequestBody UsernamePassword user){
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
	
}



class GetUserName{
	public String username;
}

class GetDetail{
	public int suggestionId;
	public boolean isAccepted;
	public String comment;
}

class OnlineChat{
	public String from;
	public String to;
	public String message;
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

class ProductDetail{
	public String productName;
	public double price;
	public String category;
	public String imageLink;
	public String description;
	public String addedByUserName;
}