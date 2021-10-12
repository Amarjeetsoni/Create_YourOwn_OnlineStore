package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.RatingonProductStore;

@Transactional
public interface RatingonProductByShopKeeperDao extends JpaRepository<RatingonProductStore, Long> {

}
