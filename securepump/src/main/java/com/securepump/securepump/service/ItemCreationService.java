package com.securepump.securepump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;

@Service
public interface ItemCreationService {

	public List<ItemCreationEntity> getAllItems();
	public ItemCreationEntity getItemById(Long id) throws RecordNotFoundException;
	public ItemCreationEntity createorUpdateItem(ItemCreationEntity entity);
	public void deleteItemById(Long id) throws RecordNotFoundException;
	
}
