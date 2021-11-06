package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.OnlineStore.Entity.OnlineAdminRole;

@Transactional
public interface OnlineAdminDao extends JpaRepository<OnlineAdminRole, Long>{

	public OnlineAdminRole findByUserName(String name);
	
	@Modifying
	@Query("update OnlineAdminRole sh set sh.password = ?1 where sh.userName = ?2")
	void setUserPasswordByemail(String password, String email);
	
	@Modifying 
	@Query("update OnlineAdminRole sh set sh.securityQuestion = ?1, sh.answer = ?2 where sh.userName = ?3")
	void setNewSecurityQuestion(String question, String answer, String email);
}
