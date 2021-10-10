package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineSuggestChangeOnProduct;

@Transactional
public interface OnlineSuggestChangeOnProductDao extends JpaRepository<OnlineSuggestChangeOnProduct, Long> {

}
