package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineChatDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int chatId;
	private String chatFrom;
	private String chatTo;
	private String message;
	private String date;
	
	public OnlineChatDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public OnlineChatDetails(String chatFrom, String chatTo, String message, String date) {
		super();
		this.chatFrom = chatFrom;
		this.chatTo = chatTo;
		this.message = message;
		this.date = date;
	}
	
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getChatFrom() {
		return chatFrom;
	}
	public void setChatFrom(String chatFrom) {
		this.chatFrom = chatFrom;
	}
	public String getChatTo() {
		return chatTo;
	}
	public void setChatTo(String chatTo) {
		this.chatTo = chatTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "OnlineChatDetails [chatId=" + chatId + ", chatFrom=" + chatFrom + ", chatTo=" + chatTo + ", message="
				+ message + "Date " + date + "]";
	}
	
	
}
