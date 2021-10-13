package com.cg.OnlineStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.OnlineStore.Entity.OnlineUser;
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