package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.NozzleCreationRepository;
import com.securepump.securepump.dao.NozzleReadingRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.NozzleCreationEntity;
import com.securepump.securepump.model.NozzleReadingEntity;
import com.securepump.securepump.model.ShiftDetailsEntity;
import com.securepump.securepump.service.ShiftDetailsService;

@Service("shiftDetails")
public class ShiftDetailsServiceImpl implements ShiftDetailsService {
	
	@Autowired
	@Qualifier("nozzleCreationRepo")
	NozzleCreationRepository nozzleCreationRepo;
	
	@Autowired
	@Qualifier("nozzleReadingRepo")
	NozzleReadingRepository nozzleReadingRepo;

	@Override
	public List<ShiftDetailsEntity> getAllShiftDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShiftDetailsEntity getShiftDetailsById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShiftDetailsEntity createOrUpdateShiftDetails(ShiftDetailsEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteShiftDetailsById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub

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

}
