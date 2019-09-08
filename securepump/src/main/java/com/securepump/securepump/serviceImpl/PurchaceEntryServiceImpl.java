package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.PurchaceEntryRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.PurchaseEntryEntity;
import com.securepump.securepump.service.PurchaceEntryService;

@Service("purchaceservice")
public class PurchaceEntryServiceImpl implements PurchaceEntryService {
	
	@Autowired
	PurchaceEntryRepository purchaceEntry;

	@Override
	public List<PurchaseEntryEntity> getAllItems() {
		// TODO Auto-generated method stub
		List<PurchaseEntryEntity> result = (List<PurchaseEntryEntity>) purchaceEntry.findAll();		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<PurchaseEntryEntity>();
		}
	}

	@Override
	public PurchaseEntryEntity getItemById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<PurchaseEntryEntity> purchace = purchaceEntry.findById(id);
		if(purchace.isPresent()) {
			return purchace.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public PurchaseEntryEntity createorUpdateItem(PurchaseEntryEntity entity) {
		// TODO Auto-generated method stub
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by("admin");
		entity = purchaceEntry.save(entity);
		return entity;
	}

	@Override
	public void deleteItemById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean purchaceEntity = purchaceEntry.existsById(id);
		if(purchaceEntity) 
		{
			purchaceEntry.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}
