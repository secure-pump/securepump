package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.securepump.securepump.bean.DailySaleRateBean;
import com.securepump.securepump.bean.ShiftDetailsBean;
import com.securepump.securepump.dao.NozzleCreationRepository;
import com.securepump.securepump.dao.NozzleReadingRepository;
import com.securepump.securepump.dao.ShiftDetailsRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.BoyCreationEntity;
import com.securepump.securepump.model.NozzleCreationEntity;
import com.securepump.securepump.model.NozzleReadingEntity;
import com.securepump.securepump.model.ShiftDetailsChaildEntity;
import com.securepump.securepump.model.ShiftDetailsEntity;
import com.securepump.securepump.model.UnitCreationEntity;
import com.securepump.securepump.service.ShiftDetailsService;

@Service("shiftDetails")
public class ShiftDetailsServiceImpl implements ShiftDetailsService {
	
	@Autowired
	@Qualifier("nozzleCreationRepo")
	NozzleCreationRepository nozzleCreationRepo;
	
	@Autowired
	@Qualifier("nozzleReadingRepo")
	NozzleReadingRepository nozzleReadingRepo;
	
	@Autowired
	@Qualifier("shiftDetailsRepository")
	ShiftDetailsRepository shiftDetailsRepository;

	@Override
	public List<ShiftDetailsEntity> getAllShiftDetails() {
		// TODO Auto-generated method stub
		List<ShiftDetailsEntity> result = (List<ShiftDetailsEntity>) shiftDetailsRepository.findAll();		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<ShiftDetailsEntity>();
		}
	}

	@Override
	public ShiftDetailsEntity getShiftDetailsById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<ShiftDetailsEntity> purchace = shiftDetailsRepository.findById(id);
		if(purchace.isPresent()) {
			return purchace.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@Override
	public void createOrUpdateShiftDetails(ShiftDetailsBean shiftDetailsBean) {
		// TODO Auto-generated method stub
		BoyCreationEntity boyCre=new BoyCreationEntity();
		boyCre.setId(shiftDetailsBean.getBoyId());
		
		ShiftDetailsEntity entity=new ShiftDetailsEntity();
		
		entity.setId(shiftDetailsBean.getShiftDetailsId());
		entity.setBoyCreation(boyCre);
		entity.setShiftDetailsDate(shiftDetailsBean.getShiftDetailsDate());
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by("admin");
		List<ShiftDetailsChaildEntity> allShiftDetailsChaildEntitys = new ArrayList<ShiftDetailsChaildEntity>();
		Double totalAmt=0d;
		for(int i=0;i<shiftDetailsBean.getItemNature().length;i++) {
			ShiftDetailsChaildEntity chaildEntity=new ShiftDetailsChaildEntity();
			
			UnitCreationEntity unitCre=new UnitCreationEntity();
			unitCre.setId(shiftDetailsBean.getUnitId()[i]);
			NozzleReadingEntity nozzleRe=new NozzleReadingEntity();
			nozzleRe.setNozzleName(shiftDetailsBean.getNozzleName()[i]);
			
			chaildEntity.setId(shiftDetailsBean.getShiftChaildId()[i]);
			chaildEntity.setItemNature(shiftDetailsBean.getItemNature()[i]);
			chaildEntity.setUnitCreation(unitCre);
			chaildEntity.setNozzleReadingName(nozzleRe);
			
			chaildEntity.setOpenReading(shiftDetailsBean.getOpenReading()[i]);
			chaildEntity.setCloseReading(shiftDetailsBean.getCloseReading()[i]);
			chaildEntity.setTestReading(shiftDetailsBean.getTestReading()[i]);
			chaildEntity.setSaleStock(shiftDetailsBean.getSaleStock()[i]);
			chaildEntity.setRate(shiftDetailsBean.getRate()[i]);
			chaildEntity.setTotalAmt(shiftDetailsBean.getTotalAmt()[i]);
			chaildEntity.setCreated_date(new Date());
			chaildEntity.setCreated_by("admin");
			chaildEntity.setUpdated_date(new Date());
			chaildEntity.setUpdated_by("admin");
			chaildEntity.setShiftDetailsEntity(entity);
			allShiftDetailsChaildEntitys.add(chaildEntity);
			totalAmt=totalAmt+(shiftDetailsBean.getTotalAmt()[i]==null?0d:shiftDetailsBean.getTotalAmt()[i]);
		}
		entity.setShiftDetailsChaildEntity(allShiftDetailsChaildEntitys);
		entity.setShiftStatus(false);
		entity.setTotalAmount(totalAmt);
		entity = shiftDetailsRepository.save(entity);
		
	}

	@Override
	public void deleteShiftDetailsById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean purchaceEntity = shiftDetailsRepository.existsById(id);
		if(purchaceEntity) 
		{
			shiftDetailsRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}

	}

	@Override
	public List<String> findByNozzleName(Long id) {
		// TODO Auto-generated method stub
		List<String> nozzeList=new ArrayList<String>();
		List<NozzleCreationEntity> nozzleList=nozzleCreationRepo.findByUnitCreationId(id);
		for(NozzleCreationEntity nozz:nozzleList){
			nozzeList.add(nozz.getNozzleName());
		}
		return nozzeList;
	}
	@Override
	public int findByNozzleReading(String nozzleName) {
		// TODO Auto-generated method stub
		NozzleReadingEntity nozzleList=nozzleReadingRepo.findByNozzleName(nozzleName);
		
		return nozzleList.getNozzleReading();
	}

	@Override
	public Double getSalePrice(String nozzleName, String date) {
		// TODO Auto-generated method stub
		Double nozzleList=shiftDetailsRepository.getSalePrice(nozzleName,date);
		return nozzleList;
	}

	@Override
	public DailySaleRateBean getshiftDatePriceDetails(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
