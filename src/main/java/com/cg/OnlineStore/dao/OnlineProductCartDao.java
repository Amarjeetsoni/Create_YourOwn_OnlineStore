package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineProductCart;

@Transactional
public interface OnlineProductCartDao extends JpaRepository<OnlineProductCart, Long> {

}
