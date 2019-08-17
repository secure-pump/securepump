package com.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.securepump.dao.AccountCreationRepository;
import com.securepump.exception.RecordNotFoundException;
import com.securepump.model.AccountCreationEntity;
import com.securepump.service.AccountCreationService;

@Service
@Configurable
public class AccountCreationServiceImpl implements AccountCreationService {

	@Autowired
	AccountCreationRepository accountRepository;
	

	@Override
	public List<AccountCreationEntity> getAllAccounts() {
		// TODO Auto-generated method stub
		List<AccountCreationEntity> result = (List<AccountCreationEntity>) accountRepository.findAll();		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<AccountCreationEntity>();
		}

	}

	@Override
	public AccountCreationEntity getAccountsById(Long id) throws RecordNotFoundException   {
		// TODO Auto-generated method stub
		Optional<AccountCreationEntity> employee = accountRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public AccountCreationEntity createOrUpdateAccounts(AccountCreationEntity entity) {
		// TODO Auto-generated method stub
		
			entity.setCreated_date(new Date());
			entity.setCreated_by(0);
			entity.setUpdated_date(new Date());
			entity.setUpdated_by(0);
			entity = accountRepository.save(entity);
			return entity;
		
	}

	@Override
	public void deleteAccountsById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<AccountCreationEntity> employee = accountRepository.findById(id);
		if(employee.isPresent()) 
		{
			accountRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	} 

}
