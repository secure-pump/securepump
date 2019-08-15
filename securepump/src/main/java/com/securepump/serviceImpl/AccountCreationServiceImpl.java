package com.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.dao.AccountCreationRepository;
import com.securepump.exception.RecordNotFoundException;
import com.securepump.model.AccountCreationEntity;
import com.securepump.service.AccountCreationService;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {

	@Autowired
	AccountCreationRepository repository;

	
	@Override
	public List<AccountCreationEntity> getAllAccounts() {
		// TODO Auto-generated method stub
		List<AccountCreationEntity> result = (List<AccountCreationEntity>) repository.findAll();		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<AccountCreationEntity>();
		}

	}

	@Override
	public AccountCreationEntity getAccountsById(Long id) throws RecordNotFoundException   {
		// TODO Auto-generated method stub
		Optional<AccountCreationEntity> employee = repository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public AccountCreationEntity createOrUpdateAccounts(AccountCreationEntity entity) {
		// TODO Auto-generated method stub
		if(entity.getId()  == null) 
		{
			entity = repository.save(entity);
			return entity;
		}else {
			Optional<AccountCreationEntity> employee = repository.findById(entity.getId());
			if(employee.isPresent()) 
			{
				AccountCreationEntity newEntity = employee.get();
				newEntity.setActName(entity.getActName());
				newEntity.setActType(entity.getActType());
				newEntity.setActGroup(entity.getActGroup());
				newEntity = repository.save(newEntity);
				return newEntity;
			} else {
				entity = repository.save(entity);
				return entity;
			}
		}
	}

	@Override
	public void deleteAccountsById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<AccountCreationEntity> employee = repository.findById(id);
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	} 

}
