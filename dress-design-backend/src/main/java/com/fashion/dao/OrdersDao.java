package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.Orders;

@Repository
public interface OrdersDao extends CrudRepository<Orders, String>{

}
