package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.NozzleCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.NozzleCreationEntity;
import com.securepump.securepump.model.TankCreationEntity;
import com.securepump.securepump.service.NozzleCreationService;
@Service("nozzleservice")
public class NozzleCreationServiceImpl implements NozzleCreationService {
	@Autowired
	NozzleCreationRepository nozzleRepo;
	@Override
	public List<NozzleCreationEntity> getAllNozzles() {
		// TODO Auto-generated method stub
		List<NozzleCreationEntity> result = (List<NozzleCreationEntity>) nozzleRepo.findAll();		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<NozzleCreationEntity>();
		}
	}

	@Override
	public NozzleCreationEntity getNozzleById(Long id) throws RecordNotFoundException {
		Optional<NozzleCreationEntity> nozzle = nozzleRepo.findById(id);
		if(nozzle.isPresent()) {
			return nozzle.get();
		} else {
			throw new RecordNotFoundException("No Nozzle record exist for given id");
		}
	}

	@Override
	public NozzleCreationEntity createorUpdateNozzle(NozzleCreationEntity entity) {
		// TODO Auto-generated method stub
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		//entity.setUpdated_by("admin");
		entity = nozzleRepo.save(entity);
		return entity;
	}

	@Override
	public void deleteNozzleById(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		boolean nozzle = nozzleRepo.existsById(id);
		if(nozzle) 
		{
			nozzleRepo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Nozzle record exist for given id");
		}
	}

}
