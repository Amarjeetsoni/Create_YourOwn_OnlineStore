package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineNotification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int notificationId;
	private String fromUser;
	private String toUser;
	private String messageVal;
	
	public OnlineNotification() {
		// TODO Auto-generated constructor stub
	}
	public OnlineNotification(String from, String to, String messageVal) {
		super();
		this.fromUser = from;
		this.toUser = to;
		this.messageVal = messageVal;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getFrom() {
		return fromUser;
	}
	public void setFrom(String from) {
		this.fromUser = from;
	}
	public String getTo() {
		return toUser;
	}
	public void setTo(String to) {
		this.toUser = to;
	}
	public String getmessageVal() {
		return messageVal;
	}
	public void setmessageVal(String messageVal) {
		this.messageVal = messageVal;
	}
	@Override
	public String toString() {
		return "OnlineNotofication [notificationId=" + notificationId + ", from=" + fromUser + ", to=" + toUser + ", messageVal="
				+ messageVal + "]";
	}
	
	
	
}
