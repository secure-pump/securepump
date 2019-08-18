package com.securepump.securepump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.SupplierCreationEntity;
@Service
public interface SupplierCreationService {
	public List<SupplierCreationEntity> getAllSuppliers();
	public SupplierCreationEntity getSupplierById(Long id) throws RecordNotFoundException;
	public SupplierCreationEntity createOrUpdateSupplier(SupplierCreationEntity entity);
	public void deleteSupplierById(Long id) throws RecordNotFoundException;
}
