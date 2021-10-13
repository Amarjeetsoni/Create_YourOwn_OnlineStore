package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String password;
	private String emailId;
	private String mobileNumber;
	private String role;
	private String securityQuestion;
	private String securityAnswer;

	public OnlineUser(){
		
	}
	
	public OnlineUser(String userName, String password, String emailId, String mobileNumber, String role, String securityQuestion, String securityAnswer) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.securityAnswer = securityAnswer;
		this.securityQuestion = securityQuestion;
	}
	
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}


	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}


	public String getSecurityAnswer() {
		return securityAnswer;
	}


	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "OnlineUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", emailId="
				+ emailId + ", mobileNumber=" + mobileNumber + ", role=" + role + ", securityQuestion="
				+ securityQuestion + ", securityAnswer=" + securityAnswer + "]";
	}
	

}
