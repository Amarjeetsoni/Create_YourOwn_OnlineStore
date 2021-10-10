package com.cg.OnlineStore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
@Transactional
public interface OnlineChatDetailsDao extends JpaRepository<OnlineChatDetails, Long> {

}
