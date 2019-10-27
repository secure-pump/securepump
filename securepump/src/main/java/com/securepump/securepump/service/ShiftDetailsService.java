package com.securepump.securepump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.securepump.securepump.bean.ShiftDetailsBean;
import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.ShiftDetailsEntity;
@Service("shiftDetails")
public interface ShiftDetailsService {
	public List<ShiftDetailsEntity> getAllShiftDetails();
	public ShiftDetailsEntity getShiftDetailsById(Long id) throws RecordNotFoundException;
	public void createOrUpdateShiftDetails(ShiftDetailsBean entity);
	public void deleteShiftDetailsById(Long id) throws RecordNotFoundException;
	public List<String> findByNozzleName(Long id);
	public int findByNozzleReading(String nozzleName);

}
