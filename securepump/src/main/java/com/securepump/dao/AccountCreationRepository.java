package com.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.model.AccountCreationEntity;
@Repository
public interface AccountCreationRepository extends CrudRepository<AccountCreationEntity, Long> {

}
