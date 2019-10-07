package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.DailySaleRateRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.DailySaleRateEntity;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.service.DailySaleRateService;

@Service("dailyRateService")
public class DailySaleRateServiceImpl implements DailySaleRateService{
	
	@Autowired
	DailySaleRateRepository dailyRateRepo;
	@Override
	public List<DailySaleRateEntity> getAllRates() {
		List<DailySaleRateEntity> result= (List<DailySaleRateEntity>) dailyRateRepo.findAll();
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<DailySaleRateEntity>();
		}
	}

	@Override
	public DailySaleRateEntity getRateById(Long id) throws RecordNotFoundException {
		Optional<DailySaleRateEntity> dailyrate = dailyRateRepo.findById(id);
		if(dailyrate.isPresent()) {
			return dailyrate.get();
		} else {
			throw new RecordNotFoundException("No Daily Rate record exist for given id");
		}
	}

	@Override
	public DailySaleRateEntity createorUpdateRate(DailySaleRateEntity entity) {
		// TODO Auto-generated method stub
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by("admin");
		entity = dailyRateRepo.save(entity);
		return entity;
	}

	@Override
	public void deleteRateById(Long id) throws RecordNotFoundException {
		boolean dailyrate = dailyRateRepo.existsById(id);
		if(dailyrate) 
		{
			dailyRateRepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Daily Rate record exist for given id");
		}
	}
	
}
