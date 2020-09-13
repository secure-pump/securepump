package com.securepump.securepump.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.BoyCreationEntity;

@Repository
public interface BoyCreationRepository extends CrudRepository<BoyCreationEntity, Long> {

	List<BoyCreationEntity> findByBoyName(String boyName);
}
