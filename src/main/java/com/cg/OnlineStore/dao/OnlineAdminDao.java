package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineAdminRole;

@Transactional
public interface OnlineAdminDao extends JpaRepository<OnlineAdminRole, Long>{

}
