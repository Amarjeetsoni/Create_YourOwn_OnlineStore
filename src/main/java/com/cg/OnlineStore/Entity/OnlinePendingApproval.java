package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlinePendingApproval {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int approvalId;
	private int ShopKeeperId;
	private boolean isApproved;
	public OnlinePendingApproval(int shopKeeperId, boolean isApproved) {
		super();
		ShopKeeperId = shopKeeperId;
		this.isApproved = isApproved;
	}
	public int getApprovalId() {
		return approvalId;
	}
	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}
	public int getShopKeeperId() {
		return ShopKeeperId;
	}
	public void setShopKeeperId(int shopKeeperId) {
		ShopKeeperId = shopKeeperId;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	@Override
	public String toString() {
		return "PendingApproval [approvalId=" + approvalId + ", ShopKeeperId=" + ShopKeeperId + ", isApproved="
				+ isApproved + "]";
	}
	
	
}
