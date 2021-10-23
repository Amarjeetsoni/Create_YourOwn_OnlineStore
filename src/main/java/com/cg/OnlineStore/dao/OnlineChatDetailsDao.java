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
	@Query("Select OnlineChatDetails chat where (chat.from = ?1 and chat.to = ?2) or (chat.from = ?2 and chat.to = ?1)")
	List<OnlineChatDetails> getOnlineChat(String user1, String user2);
	
	
	
}
