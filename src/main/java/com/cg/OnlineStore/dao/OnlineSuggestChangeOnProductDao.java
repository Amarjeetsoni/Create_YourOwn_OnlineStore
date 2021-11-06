package com.cg.OnlineStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineSuggestChangeProduct;

@Transactional
public interface OnlineSuggestChangeOnProductDao extends JpaRepository<OnlineSuggestChangeProduct, Long> {

	List<OnlineSuggestChangeProduct> findByToShopKeeper(String username);
	List<OnlineSuggestChangeProduct> findByByUserId(String name);
}
