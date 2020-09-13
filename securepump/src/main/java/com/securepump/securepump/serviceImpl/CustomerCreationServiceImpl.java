package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.CutomerCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.service.CustomerCreationService;

@Service
public class CustomerCreationServiceImpl implements CustomerCreationService {
	
	@Autowired 
	CutomerCreationRepository custRepositoy;
	@Override
	public List<CustomerCreationEntity> getAllCutomer() {
		List<CustomerCreationEntity> result = (List<CustomerCreationEntity>) custRepositoy.findAll();
		if(result.size() > 0) {
			return result;
		} 
		else {
			return new ArrayList<CustomerCreationEntity>();
		}

	}

	@Override
	public CustomerCreationEntity getCustomerById(Long id) throws RecordNotFoundException {
		Optional<CustomerCreationEntity> customer=custRepositoy.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			throw new RecordNotFoundException("No Customer record exist for given id");
		}
	}

	@Override
	public CustomerCreationEntity createOrUpdateCustomer(CustomerCreationEntity entity) {
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by(0);
		entity=custRepositoy.save(entity);
		return entity;
	}

	@Override
	public void deleteCustomerById(Long id) throws RecordNotFoundException {
		Optional<CustomerCreationEntity> customer=custRepositoy.findById(id);
		if(customer.isPresent()) {
			custRepositoy.deleteById(id);
		}
		else {
			throw new RecordNotFoundException("No Customer record exist for given id");
		}
	}

	@Override
	public boolean getCustomerByMobile(String mobile) {
		// TODO Auto-generated method stub
		List<CustomerCreationEntity> cus=custRepositoy.findByMobileNo(mobile);
		if(cus.size() > 0) {
			return true;
		}else {
		return false;
		}
	}

}
