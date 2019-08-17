package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.AccountCreationEntity;
@Repository
public interface AccountCreationRepository extends CrudRepository<AccountCreationEntity, Long> {

}
