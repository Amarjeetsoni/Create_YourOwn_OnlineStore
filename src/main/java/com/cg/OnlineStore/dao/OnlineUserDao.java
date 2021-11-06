package com.cg.OnlineStore.dao;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.OnlineStore.Entity.OnlineUser;

@Transactional
public interface OnlineUserDao extends JpaRepository<OnlineUser, Long> {
	public OnlineUser findByEmailId(String email);
	
	@Modifying
	@Query("update OnlineUser sh set sh.password = ?1 where sh.emailId = ?2")
	void setUserPasswordByemail(String password, String email);
	
	@Modifying 
	@Query("update OnlineUser sh set sh.securityQuestion = ?1, sh.securityAnswer = ?2 where sh.emailId = ?3")
	void setNewSecurityQuestion(String question, String answer, String email);
}
