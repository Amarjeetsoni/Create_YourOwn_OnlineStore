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

import com.cg.OnlineStore.Entity.OnlineChatDetails;
import com.cg.OnlineStore.Entity.OnlineProductCart;
import com.cg.OnlineStore.Entity.OnlineProductDetails;
import com.cg.OnlineStore.Entity.OnlineShopKeeper;
import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;
import com.cg.OnlineStore.Entity.OnlineUser;
import com.cg.OnlineStore.Entity.RatingOnShopKeeper;
import com.cg.OnlineStore.Entity.RatingonProductStore;
import com.cg.OnlineStore.services.UserServices;

@SpringBootApplication
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServices userService;
	
	@RequestMapping(value = "/checkDetail")
	public ResponseEntity<Object> checkDetails(@RequestBody CheckUserDetails userDetail){
		String str = userService.isUserDtailsCorrect(userDetail.emailId, userDetail.mobileNumber);
		if(str.equals("success")) {
			return new ResponseEntity<Object>("Accepted", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(str,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<Object> insertDetails(@RequestBody GetNewUserDetail uDetail){
		OnlineUser user = new OnlineUser(uDetail.userName, uDetail.password, uDetail.emailId, uDetail.mobileNumber, "User", uDetail.securityQuestion, uDetail.securityAnswer);
		if(userService.registerUser(user)) {
			return new ResponseEntity<Object>("Details Saved Successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents wrong!!", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> loginDetails(@RequestBody GetUserNamePassword detail){
		OnlineUser user = userService.logIn(detail.email, detail.password);
		if(user == null) {
			return new ResponseEntity<Object>("UserName/Password is wrong!", HttpStatus.UNAUTHORIZED);
		}
		else {
			return new ResponseEntity<Object>(user, HttpStatus.OK);
		}
	}
	
	@PostMapping("/validateSecurity")
	public ResponseEntity<Object> CheckSecurityQuestionDetail(@RequestBody CheckSecurityQuestion security){
		String str = userService.checkSecurityQuestionDetails(security.UserName, security.question, security.answer);
		if(str.equals("success !")) {
			return new ResponseEntity<Object>(str, HttpStatus.OK);
		}
		return new ResponseEntity<Object>(str, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/changeSequrityQuestion")
	public ResponseEntity<Object> ChangeSecurityQuestion(@RequestBody SecurityQuestion user){
		boolean temp = userService.changeSecurityQuestion(user.email, user.question, user.answer);
		if(temp) {
			return new ResponseEntity<Object>("Details Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Someting wents wrong!", HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/updatepassword")
	public ResponseEntity<Object> UpdatePassword(@RequestBody UsernamePassword user){
		boolean temp = userService.changePassword(user.email, user.password);
		if(temp) {
			return new ResponseEntity<Object> ("Password Updated !", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object> ("Something wents wrong !", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/getProdList")
	public ResponseEntity<Object> getProductList(){
		List<OnlineProductDetails> prod = userService.getProductList();
		if(prod.isEmpty()) {
			return new ResponseEntity<Object>("No Product Details are available!!", HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Object>(prod, HttpStatus.OK);
		}
	}
	
	@PostMapping("/getAllRatingProductByUserName")
	public ResponseEntity<Object> getAllRatingbyUserName(@RequestBody UsernamePassword detail){
		List<RatingonProductStore> getAll = userService.showAllRatingByUser(detail.email);
		if(getAll.isEmpty()) {
			return new ResponseEntity<Object>("No Rating is added by You!, please go ahead and rate some of our product so that we will be improve.", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(getAll, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addRatingProduct")
	public ResponseEntity<Object> addRatingInProduct(@RequestBody AddProductRaingDetail detail){
		RatingonProductStore rate = new RatingonProductStore(detail.rating, detail.productName,detail.addedByShopKeeper,detail.Message, detail.category, detail.ratingBy);
		if(userService.addRatinginProduct(rate)) {
			return new ResponseEntity<Object>("Thanks for Rating!", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@DeleteMapping("/deleteRatingProduct")
	public ResponseEntity<Object> DeleteRatingOnProduct(@RequestParam("Id") int ratingId){
		if(userService.deleteRatingOnProduct(ratingId)) {
			return new ResponseEntity<Object>("Rating is successfully Removed from the Product!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/getAllRatingShopkeeperByUserName")
	public ResponseEntity<Object> getAllRatingOnShopkeeperbyUserName(@RequestParam("ID") int detail){
		List<RatingOnShopKeeper> getAll = userService.showAllRatingOnShopKeeperByUser(detail);
		if(getAll.isEmpty()) {
			return new ResponseEntity<Object>("No Rating is added by You!, please go ahead and rate some of our product so that we will be improve.", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(getAll, HttpStatus.OK);
		}
	}
	
	@PostMapping("/addRatingshopkeeper")
	public ResponseEntity<Object> addRatingonShopKeeper(@RequestBody AddShopkeeperRatingDetail detail){
		RatingOnShopKeeper rate = new RatingOnShopKeeper(detail.rating, detail.customerUserName, detail.Message, detail.shopkeeperId);
		if(userService.addRatingOfshopKeepers(rate)) {
			return new ResponseEntity<Object>("Thanks for Rating!", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/getchat")
	public ResponseEntity<Object> getChat(@RequestParam("user1") String user1, @RequestParam("user2") String user2){
		List<OnlineChatDetails> listchat = userService.getChat(user1, user2);
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
		if(userService.storeChat(chatto)) {
			return new ResponseEntity<Object>("Saved Successfully!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something Wents wrong!!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/AddProdCart")
	public ResponseEntity<Object> AddProductToCart(@RequestBody AddToCart cart){
		OnlineProductCart newprod = new OnlineProductCart(cart.productId, cart.byUserName);
		String str = userService.addProductInCart(newprod);
		if(str.equals("Success")) {
			return new ResponseEntity<Object>("Product Added in the cart Successfully!", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(str, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/DeleteProdCart")
	public ResponseEntity<Object> DeleteProdFromCart(@RequestBody AddToCart cart){
		if(userService.deleteProductInCart(cart.productId, cart.byUserName)) {
			return new ResponseEntity<Object>("Deleted From the cart!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllprodInCart")
	public ResponseEntity<Object> getAllproInCart(@RequestParam("userName") String username){
		List<OnlineProductCart> listofProd = userService.getAllProdInCart(username);
		if(listofProd.isEmpty()) {
			return new ResponseEntity<Object>("No Product is added in the cart yet, Please add and visite here again!", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(listofProd, HttpStatus.OK);
		}
	}
	@GetMapping("/getAllShopKeeper")
	public ResponseEntity<Object> getAllShopKeeperDetails(){
		List<OnlineShopKeeper> getAll = userService.getAllShopKepperShopDetails();
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
	
	@PostMapping("/addSuggestAChange")
	public ResponseEntity<Object> suggestAnewChange(@RequestBody SuggestAchange change){
		OnlineSuggestChangeProduct chan = new OnlineSuggestChangeProduct(change.toShopKeeper, change.byUserId, change.ProductItemId, change.changeDetails, false, null);
		if(userService.SuggestChange(chan)) {
			return new ResponseEntity<Object>("Request Send to ShopKeeper, wait until he takes any action!", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>("Something wents Wrong!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/getAllSuggestion")
	public ResponseEntity<Object> getAllChangeRequested(@RequestBody GetUserName user){
		List<OnlineSuggestChangeProduct> prod = userService.getByUserName(user.username);
		if(prod.isEmpty()) {
			return new ResponseEntity<Object>("No Suggestion you have given yet!Please provide some thing", HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<Object>(prod, HttpStatus.OK);
		}
	}
	
	
	
}

class SuggestAchange{
	public String toShopKeeper;
	public String byUserId;
	public int ProductItemId;
	public String changeDetails;
}

class SendShopKeeperDetail{
	public String shopKeeperUserName;
	public int totalProductAdded;
	public String emailId;
	public String nameOfShop;
	public String Address;
	public String shopType;
	public double rating;
	public int totalRating;
	public SendShopKeeperDetail(String shopKeeperUserName, int totalProductAdded, String emailId, String nameOfShop,
			String address, String shopType, double rating, int totalRating) {
		super();
		this.shopKeeperUserName = shopKeeperUserName;
		this.totalProductAdded = totalProductAdded;
		this.emailId = emailId;
		this.nameOfShop = nameOfShop;
		Address = address;
		this.shopType = shopType;
		this.rating = rating;
		this.totalRating = totalRating;
	}
	
}

class AddToCart{
	public int productId;
	public String byUserName;
}

class AddShopkeeperRatingDetail{
	public double rating;
	public int customerUserName;
	public String Message;
	public int shopkeeperId;
}

class AddProductRaingDetail{
	public double rating;
	public int productName;
	public String addedByShopKeeper;
	public String Message;
	public String category;
	public String ratingBy;
}

class CheckUserDetails{
	public String emailId;
	public String mobileNumber;
}
class GetNewUserDetail{
	public String userName;
	public String password;
	public String emailId;
	public String mobileNumber;
	public String securityQuestion;
	public String securityAnswer;
}
class GetUserNamePassword{
	public String email;
	public String password;
}