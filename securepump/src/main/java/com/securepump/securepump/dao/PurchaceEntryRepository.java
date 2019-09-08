package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.PurchaseEntryEntity;

@Repository
public interface PurchaceEntryRepository extends CrudRepository<PurchaseEntryEntity, Long>{

}
