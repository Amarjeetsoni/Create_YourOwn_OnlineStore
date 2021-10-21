package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.OnlineStore.Entity.OnlineShopKeeper;

@Transactional
public interface OnlineShopkeeperDao extends JpaRepository<OnlineShopKeeper, Long> {
		public OnlineShopKeeper findByemailId(String mail);
		
		@Modifying
		@Query("update OnlineShopKeeper sh set sh.shopKeeperPassword = ?1 where sh.emailId = ?2")
		void setUserPasswordByemail(String password, String email);
		
		@Modifying 
		@Query("update OnlineShopKeeper sh set sh.securityQuestion = ?1, sh.answer = ?2 where sh.emailId = ?3")
		void setNewSecurityQuestion(String question, String answer, String email);
		
		
}
