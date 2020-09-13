package com.securepump.securepump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.CustomerCreationEntity;

@Service
public interface CustomerCreationService {

	public List<CustomerCreationEntity> getAllCutomer();
	public CustomerCreationEntity getCustomerById(Long id) throws RecordNotFoundException;
	public boolean getCustomerByMobile(String mobile);
	public CustomerCreationEntity createOrUpdateCustomer(CustomerCreationEntity entity);
	public void deleteCustomerById(Long id) throws RecordNotFoundException;
	
}
