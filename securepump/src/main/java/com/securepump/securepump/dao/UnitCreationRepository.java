package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.securepump.securepump.model.UnitCreationEntity;

@Repository
public interface UnitCreationRepository extends CrudRepository<UnitCreationEntity, Long>{ 

}
