package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineProductCategory;

@Transactional
public interface OnlineProductCategoryDao extends JpaRepository<OnlineProductCategory, Long> {

}
