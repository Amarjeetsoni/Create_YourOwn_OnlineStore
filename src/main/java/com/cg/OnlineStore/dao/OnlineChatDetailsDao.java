package com.cg.OnlineStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cg.OnlineStore.Entity.OnlineChatDetails;
@Transactional
public interface OnlineChatDetailsDao extends JpaRepository<OnlineChatDetails, Long> {
	
	
	@Modifying
	@Query("SELECT chat FROM OnlineChatDetails chat WHERE (chat.chatFrom = ?1 AND chat.chatTo = ?2) OR (chat.chatFrom = ?2 AND chat.chatTo = ?1)")
	List<OnlineChatDetails> getOnlineChat(String user1, String user2);
	
	
	
}
