package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineProductDetails;

@Transactional
public interface OnlineProductDetailsDao extends JpaRepository<OnlineProductDetails, Long> {

}
