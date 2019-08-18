package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.SupplierCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.SupplierCreationEntity;
import com.securepump.securepump.service.SupplierCreationService;

@Service
public class SupplierCreationServiceImpl implements SupplierCreationService {
	@Autowired
	SupplierCreationRepository supplierRepository;
	@Override
	public List<SupplierCreationEntity> getAllSuppliers() {
		List<SupplierCreationEntity> result=(List<SupplierCreationEntity>) supplierRepository.findAll();
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<SupplierCreationEntity>();
		}
	}

	@Override
	public SupplierCreationEntity getSupplierById(Long id) throws RecordNotFoundException {
		Optional<SupplierCreationEntity> supplier=supplierRepository.findById(id);
		if(supplier.isPresent())
		{
			return supplier.get();
		}
		else
		{
			throw new RecordNotFoundException("Supplier name is not available");
		}
	}

	@Override
	public SupplierCreationEntity createOrUpdateSupplier(SupplierCreationEntity entity) {
		entity.setCreated_date(new Date());
		entity.setCreated_by("ADMIN");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by(0);
		entity=supplierRepository.save(entity);
		return entity;
	}

	@Override
	public void deleteSupplierById(Long id) throws RecordNotFoundException {
		Optional<SupplierCreationEntity> supplier=supplierRepository.findById(id);
		if(supplier.isPresent()) {
			supplierRepository.deleteById(id);
		}
		else {
			throw new RecordNotFoundException("Supplier was nor Found");
		}
		
	}

}
