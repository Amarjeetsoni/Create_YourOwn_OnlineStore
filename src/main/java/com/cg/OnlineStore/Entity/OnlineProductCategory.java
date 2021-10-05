package com.cg.OnlineStore.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OnlineProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	private String CategoryName;
	
	
	public OnlineProductCategory(String categoryName, double ratingOnCategory) {
		super();
		CategoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	@Override
	public String toString() {
		return "OnlineProductCategory [categoryId=" + categoryId + ", CategoryName=" + CategoryName
				 + "]";
	}
	
}
