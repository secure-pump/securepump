package com.securepump.securepump.dao;

import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.CustomerCreationEntity;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CutomerCreationRepository extends CrudRepository<CustomerCreationEntity, Long> {

}
