package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlinePendingApproval;

@Transactional
public interface OnlinePendingApprovalDao extends JpaRepository<OnlinePendingApproval, Long> {

}
