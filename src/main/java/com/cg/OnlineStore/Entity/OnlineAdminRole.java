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
	private String securityQuestion;
	private String answer;
	public OnlineAdminRole(String userName, String password, int totalpendingApproval,
			String securityQuestion, String answer) {
		super();
		this.userName = userName;
		this.password = password;
		this.securityQuestion = securityQuestion;
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
	@Override
	public String toString() {
		return "OnlineAdminRole [AdminRole=" + AdminRole + ", userName=" + userName + ", password=" + password
				+ ", totalpendingApproval=" + securityQuestion
				+ ", answer=" + answer + "]";
	}
		
}
