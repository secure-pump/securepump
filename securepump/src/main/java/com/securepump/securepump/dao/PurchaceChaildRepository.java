package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.PurchaseChaildEntity;

@Repository("PurchaceChaildRepo")
public interface PurchaceChaildRepository extends CrudRepository<PurchaseChaildEntity, Long>{

}
