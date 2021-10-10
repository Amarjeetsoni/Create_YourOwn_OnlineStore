package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineAdminRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AdminRole;
	private String userName;
	private String password;
	private int totalActiveUser;
	private int totalActiveShopkeepers;
	private int totalProductAdded;
	private int totalRatingReceived;
	private int totalpendingApproval;
	private String securityQuestion;
	private String answer;
	
	
	public OnlineAdminRole(String userName, String password, int totalActiveUser, String ques, String ans, 
			int totalActiveShopkeepers, int totalProductAdded, int totalRatingReceived, int totalpendingApproval) {
		super();
		this.userName = userName;
		this.password = password;
		this.totalActiveUser = totalActiveUser;
		this.totalActiveShopkeepers = totalActiveShopkeepers;
		this.totalProductAdded = totalProductAdded;
		this.totalRatingReceived = totalRatingReceived;
		this.totalpendingApproval = totalpendingApproval;
		this.securityQuestion = ques;
		this.answer = ans;
	}
	
	
	public String getSecurityQuestion() {
		return securityQuestion;
	}


	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public int getAdminRole() {
		return AdminRole;
	}
	public void setAdminRole(int adminRole) {
		AdminRole = adminRole;
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
	public int getTotalActiveUser() {
		return totalActiveUser;
	}
	public void setTotalActiveUser(int totalActiveUser) {
		this.totalActiveUser = totalActiveUser;
	}
	public int getTotalActiveShopkeepers() {
		return totalActiveShopkeepers;
	}
	public void setTotalActiveShopkeepers(int totalActiveShopkeepers) {
		this.totalActiveShopkeepers = totalActiveShopkeepers;
	}
	public int getTotalProductAdded() {
		return totalProductAdded;
	}
	public void setTotalProductAdded(int totalProductAdded) {
		this.totalProductAdded = totalProductAdded;
	}
	public int getTotalRatingReceived() {
		return totalRatingReceived;
	}
	public void setTotalRatingReceived(int totalRatingReceived) {
		this.totalRatingReceived = totalRatingReceived;
	}
	public int getTotalpendingApproval() {
		return totalpendingApproval;
	}
	public void setTotalpendingApproval(int totalpendingApproval) {
		this.totalpendingApproval = totalpendingApproval;
	}
	@Override
	public String toString() {
		return "OnlineAdminRole [AdminRole=" + AdminRole + ", userName=" + userName + ", password=" + password
				+ ", totalActiveUser=" + totalActiveUser + ", totalActiveShopkeepers=" + totalActiveShopkeepers
				+ ", totalProductAdded=" + totalProductAdded + ", totalRatingReceived=" + totalRatingReceived
				+ ", totalpendingApproval=" + totalpendingApproval + ", securityQuestion=" + securityQuestion
				+ ", answer=" + answer + "]";
	}
	
	
}
