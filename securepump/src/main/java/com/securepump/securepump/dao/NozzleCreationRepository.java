package com.securepump.securepump.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.NozzleCreationEntity;
@Repository("nozzleCreationRepo")
public interface NozzleCreationRepository extends CrudRepository<NozzleCreationEntity, Long> {
	
	@Async
	List<NozzleCreationEntity> findByUnitCreationId(Long IdUnitCreation);

}
