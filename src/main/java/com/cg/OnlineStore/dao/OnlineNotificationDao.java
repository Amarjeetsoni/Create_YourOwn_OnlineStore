package com.cg.OnlineStore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.OnlineStore.Entity.OnlineNotification;

public interface OnlineNotificationDao extends JpaRepository<OnlineNotification, Long>{

	public List<OnlineNotification> findByToUser(String name);
}
