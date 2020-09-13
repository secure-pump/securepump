package com.securepump.securepump.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.securepump.securepump.dao.BoyCreationRepository;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.BoyCreationEntity;
import com.securepump.securepump.model.CustomerCreationEntity;
import com.securepump.securepump.service.BoyCreationService;

@Service("boyService")
public class BoyCreationServiceImpl implements BoyCreationService {

	@Autowired
	BoyCreationRepository boyrepo;
	@Override
	public List<BoyCreationEntity> getAllCutomer() {
		List<BoyCreationEntity> result = (List<BoyCreationEntity>) boyrepo.findAll();
		if(result.size() > 0) {
			return result;
		} 
		else {
			return new ArrayList<BoyCreationEntity>();
		}
	}

	@Override
	public BoyCreationEntity getBoyById(Long id) throws RecordNotFoundException {
		Optional<BoyCreationEntity> boy=boyrepo.findById(id);
		if(boy.isPresent()) {
			return boy.get();
		}
		else {
			throw new RecordNotFoundException("No Boy record exist for given id");
		}
	}

	@Override
	public BoyCreationEntity createOrUpdateBoy(BoyCreationEntity entity) {
		entity.setCreated_date(new Date());
		entity.setCreated_by("admin");
		entity.setUpdated_date(new Date());
		entity.setUpdated_by(0);
		entity=boyrepo.save(entity);
		return entity;
	}

	@Override
	public void deleteBoyById(Long id) throws RecordNotFoundException {
		Optional<BoyCreationEntity> boy=boyrepo.findById(id);
		if(boy.isPresent()) {
			boyrepo.deleteById(id);
		}
		else {
			throw new RecordNotFoundException("No Boy record exist for given id");
		}
	}

	@Override
	public boolean getBoyName(String bname) {
		// TODO Auto-generated method stub
		List<BoyCreationEntity> bStatus=boyrepo.findByBoyName(bname);
		if(bStatus.size()>0) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
