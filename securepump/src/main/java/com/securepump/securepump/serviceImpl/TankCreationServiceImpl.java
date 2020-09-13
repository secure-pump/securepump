package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.TankCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.service.TankCreationService;

@Service("tankservice")
public class TankCreationServiceImpl implements TankCreationService {
	
	@Autowired
	TankCreationRepository tankRepository;

	@Override
	public List<TankCreationEntity> getAllItems() {
		// TODO Auto-generated method stub
		List<TankCreationEntity> result = (List<TankCreationEntity>) tankRepository.findAll();		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<TankCreationEntity>();
		}
	}

	@Override
	public TankCreationEntity getItemById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<TankCreationEntity> employee = tankRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public TankCreationEntity createorUpdateItem(TankCreationEntity entity) {
		// TODO Auto-generated method stub
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by("admin");
		entity = tankRepository.save(entity);
		return entity;
	}

	@Override
	public void deleteItemById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean employee = tankRepository.existsById(id);
		if(employee) 
		{
			tankRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public boolean getTankName(String name) {
		// TODO Auto-generated method stub
		List<TankCreationEntity> tankDetails=tankRepository.findByTankName(name);
		if(tankDetails.size()>0) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
