package com.securepump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.securepump.exception.RecordNotFoundException;
import com.securepump.model.AccountCreationEntity;
@Service
@Configurable
public interface AccountCreationService {
	
	public List<AccountCreationEntity> getAllAccounts();
	public AccountCreationEntity getAccountsById(Long id) throws RecordNotFoundException;
	public AccountCreationEntity createOrUpdateAccounts(AccountCreationEntity entity);
	public void deleteAccountsById(Long id) throws RecordNotFoundException;

}
