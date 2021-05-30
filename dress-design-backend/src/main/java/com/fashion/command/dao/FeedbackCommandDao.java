package com.fashion.command.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.entity.Feedback;

@Repository
public interface FeedbackCommandDao extends JpaRepository<Feedback, UUID> {
	
}
