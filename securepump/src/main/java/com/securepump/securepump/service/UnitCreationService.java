package com.securepump.securepump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.SupplierCreationEntity;
import com.securepump.securepump.model.UnitCreationEntity;

@Service("unitservice")
public interface UnitCreationService {
	public List<UnitCreationEntity> getAllUnits();
	public UnitCreationEntity getUnitById(Long id) throws RecordNotFoundException;
	public boolean getUnitName(String uname);
	public UnitCreationEntity createOrUpdateUnit(UnitCreationEntity entity);
	public void deleteUnitById(Long id) throws RecordNotFoundException;
}
