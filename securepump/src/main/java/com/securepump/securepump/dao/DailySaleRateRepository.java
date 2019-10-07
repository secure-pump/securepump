package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.DailySaleRateEntity;

@Repository
public interface DailySaleRateRepository extends CrudRepository<DailySaleRateEntity, Long>{

}
