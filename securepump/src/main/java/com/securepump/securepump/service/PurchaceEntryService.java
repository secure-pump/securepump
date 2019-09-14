package com.securepump.securepump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.securepump.securepump.bean.PurchaceEntryBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.PurchaseEntryEntity;

@Service("purchaceservice")
@Configurable
public interface PurchaceEntryService {
	public List<PurchaseEntryEntity> getAllItems();
	public PurchaseEntryEntity getItemById(Long id) throws RecordNotFoundException;
	public void createorUpdateItem(PurchaceEntryBean entity);
	public void deleteItemById(Long id) throws RecordNotFoundException;
}
