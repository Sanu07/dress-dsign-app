package com.fashion.command.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.entity.Order;

@Repository
public interface OrdersCommandDao extends JpaRepository<Order, UUID> {
	
}
