package com.securepump.securepump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.NozzleCreationEntity;

@Service("nozzleservice")
@Configurable
public interface NozzleCreationService {
	public List<NozzleCreationEntity> getAllNozzles();
	public NozzleCreationEntity getNozzleById(Long id) throws RecordNotFoundException;
	public boolean getNozzleName(String nozzleName);
	public NozzleCreationEntity createorUpdateNozzle(NozzleCreationEntity entity);
	public void deleteNozzleById(Long id) throws RecordNotFoundException;

}
