package com.securepump.securepump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.BoyCreationEntity;
import com.securepump.securepump.model.CustomerCreationEntity;

@Service("boyService")
public interface BoyCreationService {

	public List<BoyCreationEntity> getAllCutomer();
	public BoyCreationEntity getBoyById(Long id) throws RecordNotFoundException;
	public BoyCreationEntity createOrUpdateBoy(BoyCreationEntity entity);
	public void deleteBoyById(Long id) throws RecordNotFoundException;
}
