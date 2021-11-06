package com.cg.OnlineStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.RatingonProductStore;

@Transactional
public interface RatingonProductByShopKeeperDao extends JpaRepository<RatingonProductStore, Long> {

    public List<RatingonProductStore> findByAddedByShopKeeper(String name);
    public List<RatingonProductStore> findByProductName(int num);
    public List<RatingonProductStore> findByRatingBy(String user);
}
