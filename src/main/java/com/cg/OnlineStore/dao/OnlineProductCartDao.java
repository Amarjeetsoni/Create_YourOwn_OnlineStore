package com.cg.OnlineStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.OnlineStore.Entity.OnlineProductCart;

@Transactional
public interface OnlineProductCartDao extends JpaRepository<OnlineProductCart, Long> {
	
	@Modifying
	@Query("Select sh FROM OnlineProductCart sh WHERE sh.productID = ?1 AND sh.byUser = ?2")
	OnlineProductCart getProductByProdId(int prodId, String email);

	List<OnlineProductCart> findByByUser(String userName);
}
