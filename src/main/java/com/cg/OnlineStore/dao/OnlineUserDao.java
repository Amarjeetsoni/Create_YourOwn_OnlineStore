package com.cg.OnlineStore.dao;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineUser;

@Transactional
public interface OnlineUserDao extends JpaRepository<OnlineUser, Long> {
	public OnlineUser findByEmailId(String email);
	
}
