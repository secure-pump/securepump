package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.UnitCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.model.UnitCreationEntity;
import com.securepump.securepump.service.UnitCreationService;

@Service
public class UnitCreationServiceImpl implements UnitCreationService {
	@Autowired
	UnitCreationRepository unitrepo;

	@Override
	public List<UnitCreationEntity> getAllUnits() {
		List<UnitCreationEntity> result = (List<UnitCreationEntity>) unitrepo.findAll();
		if(result.size() > 0) {
			return result;
		} 
		else {
			return new ArrayList<UnitCreationEntity>();
		}

	}

	@Override
	public UnitCreationEntity getUnitById(Long id) throws RecordNotFoundException {
		Optional<UnitCreationEntity> unit=unitrepo.findById(id);
		if(unit.isPresent()) {
			return unit.get();
		}
		else {
			throw new RecordNotFoundException("No Unit Name record exist for given id");
		}
	}

	@Override
	public UnitCreationEntity createOrUpdateUnit(UnitCreationEntity entity) {
		entity.setCreated_date(new Date());
		//entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by(0);
		entity=unitrepo.save(entity);
		return entity;
	}

	@Override
	public void deleteUnitById(Long id) throws RecordNotFoundException {
		Optional<UnitCreationEntity> customer=unitrepo.findById(id);
		if(customer.isPresent()) {
			unitrepo.deleteById(id);
		}
		else {
			throw new RecordNotFoundException("No Unit Name record exist for given id");
		}
	}
	

}
