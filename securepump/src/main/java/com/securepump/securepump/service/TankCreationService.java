package com.securepump.securepump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.TankCreationEntity;

@Service("tankservice")
@Configurable
public interface TankCreationService {

	public List<TankCreationEntity> getAllItems();
	public TankCreationEntity getItemById(Long id) throws RecordNotFoundException;
	public TankCreationEntity createorUpdateItem(TankCreationEntity entity);
	public void deleteItemById(Long id) throws RecordNotFoundException;
}
