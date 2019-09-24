package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.bean.PurchaceEntryBean;
import com.securepump.securepump.dao.PurchaceEntryRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ItemCreationEntity;
import com.securepump.securepump.model.PurchaseChaildEntity;
import com.securepump.securepump.model.PurchaseEntryEntity;
import com.securepump.securepump.model.SupplierCreationEntity;
import com.securepump.securepump.service.PurchaceEntryService;

@Service("purchaceservice")
public class PurchaceEntryServiceImpl implements PurchaceEntryService {
	
	@Autowired
	PurchaceEntryRepository purchaceEntry;
	
	/*@Autowired
	@Qualifier("PurchaceChaildRepo")
	PurchaceChaildRepository purchaceChaildRep;*/

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
	public void createorUpdateItem(PurchaceEntryBean purchaceBean) {
		// TODO Auto-generated method stub
			SupplierCreationEntity supplyCre=new SupplierCreationEntity();
			supplyCre.setId(purchaceBean.getSupplierId());
			
			PurchaseEntryEntity entity=new PurchaseEntryEntity();
			
			entity.setId(purchaceBean.getPurchaceid());
			entity.setInvoiceDate(purchaceBean.getInvoiceDate());
			entity.setBillMode(purchaceBean.getBillMode());	
			entity.setSupplierCreation(supplyCre);
			entity.setSupplierInvoiceNum(purchaceBean.getSupplierInvoiceNum());
			entity.setCreated_date(new Date());
			entity.setCreated_by("admin");
			entity.setUpdated_date(new Date());
			entity.setUpdated_by("admin");
			List<PurchaseChaildEntity> allPurchaseChaildEntitys = new ArrayList<PurchaseChaildEntity>();
			
			for(int i=0;i<purchaceBean.getItemId().length;i++) {
				PurchaseChaildEntity chaildEntity=new PurchaseChaildEntity();
				
				ItemCreationEntity itemCre=new ItemCreationEntity();
				itemCre.setId(purchaceBean.getItemId()[i]);
				
				chaildEntity.setId(purchaceBean.getPurchaceChaildId()[i]);
				chaildEntity.setItemCreation(itemCre);
				chaildEntity.setQuantity(purchaceBean.getQuantity()[i]);
				chaildEntity.setRate(purchaceBean.getRate()[i]);
				chaildEntity.setAmount(purchaceBean.getAmount()[i]);
				chaildEntity.setSgst(purchaceBean.getSgst()[i]);
				chaildEntity.setCgst(purchaceBean.getCgst()[i]);
				chaildEntity.setIgst(purchaceBean.getIgst()[i]);
				chaildEntity.setNetAmt(purchaceBean.getNetAmt()[i]);
				chaildEntity.setPurchaceEntity(entity);
				chaildEntity.setCreated_date(new Date());
				chaildEntity.setCreated_by("admin");
				chaildEntity.setUpdated_date(new Date());
				chaildEntity.setUpdated_by("admin");
				allPurchaseChaildEntitys.add(chaildEntity);
				//purchaceChaildRep.save(chaildEntity);
			}
			entity.setPurchaseChaildEntity(allPurchaseChaildEntitys);
			entity = purchaceEntry.save(entity);
		
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
