package com.fashion.command.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashion.entity.Order;

@Repository
public interface OrderCommandDao extends JpaRepository<Order, UUID> {
	@Modifying
	@Query("update Order o set o.status = :status where o.id = :id")
	Order deleteOrderById(@Param(value = "id") UUID id, @Param(value = "status") boolean status);
}
