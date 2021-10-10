package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.RatingOnShopKeeper;

@Transactional
public interface RatingOnShopKeeperDao extends JpaRepository<RatingOnShopKeeper, Long> {

}
