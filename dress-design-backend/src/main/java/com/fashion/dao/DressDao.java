package com.fashion.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fashion.model.Dress;

@Repository
public interface DressDao extends CrudRepository<Dress, Long>{

}
