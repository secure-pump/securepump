package com.securepump.securepump.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.TankCreationEntity;

@Repository
public interface TankCreationRepository extends CrudRepository<TankCreationEntity, Long>{ 

	List<TankCreationEntity> findByTankName(String tankName);
}
