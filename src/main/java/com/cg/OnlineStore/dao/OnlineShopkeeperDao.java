package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineShopKeeper;

@Transactional
public interface OnlineShopkeeperDao extends JpaRepository<OnlineShopKeeper, Long> {

}
