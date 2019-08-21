package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.BoyCreationEntity;

@Repository
public interface BoyCreationRepository extends CrudRepository<BoyCreationEntity, Long> {

}
