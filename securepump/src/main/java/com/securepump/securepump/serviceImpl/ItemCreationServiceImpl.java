package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.ItemCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.service.ItemCreationService;

@Service
public class ItemCreationServiceImpl implements ItemCreationService {

	@Autowired
	ItemCreationRepository itemRepo;
	@Override
	public List<ItemCreationEntity> getAllItems() {
		// TODO Auto-generated method stub
		List<ItemCreationEntity> result=(List<ItemCreationEntity>) itemRepo.findAll();
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<ItemCreationEntity>();
		}

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemCreationEntity> getAllItemNature(String itemNature)throws RecordNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("enter itemNature");
		List<ItemCreationEntity> result=(List<ItemCreationEntity>) itemRepo.findByItemNature(itemNature);
		System.out.println("enter itemNature---"+result.size());
		if(result.size() > 0) {
			return result;
		} else {
			return (List<ItemCreationEntity>) new RecordNotFoundException("No Item record exist for given item name");
		}

	}

	@Override
	public ItemCreationEntity getItemById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<ItemCreationEntity> items = itemRepo.findById(id);
		if(items.isPresent()) {
			return items.get();
		} else {
			throw new RecordNotFoundException("No Item record exist for given id");
		}
	}
	

	@Override
	public ItemCreationEntity createorUpdateItem(ItemCreationEntity entity) {
		// TODO Auto-generated method stub
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by(0);
		entity = itemRepo.save(entity);
		return entity;
	}

	@Override
	public void deleteItemById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<ItemCreationEntity> employee = itemRepo.findById(id);
		if(employee.isPresent()) 
		{
			itemRepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Item record exist for given id");
		}
		
	}

}
