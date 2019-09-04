package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.TankCreationEntity;

@Repository
public interface TankCreationRepository extends CrudRepository<TankCreationEntity, Long>{ 

}
