package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.NozzleReadingEntity;
@Repository("nozzleReadingRepo")
public interface NozzleReadingRepository extends CrudRepository<NozzleReadingEntity, Long> {

	@Async
	NozzleReadingEntity findByNozzleName(String nozzleName);
}
