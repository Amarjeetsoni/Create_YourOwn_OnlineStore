package com.cg.OnlineStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineProductDetails;

@Transactional
public interface OnlineProductDetailsDao extends JpaRepository<OnlineProductDetails, Long> {

	public List<OnlineProductDetails> findByAddedByUserName(String name);
	
}
