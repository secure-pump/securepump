package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.ItemCreationEntity;

@Repository
public interface ItemCreationRepository extends CrudRepository<ItemCreationEntity, Long>{ 

}
