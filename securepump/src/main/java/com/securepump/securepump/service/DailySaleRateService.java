package com.securepump.securepump.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.securepump.securepump.exception.RecordNotFoundException;
import com.securepump.securepump.model.DailySaleRateEntity;

@Service("dailyRateService")
@Configurable
public interface DailySaleRateService {
	public List<DailySaleRateEntity> getAllRates();
	public DailySaleRateEntity getRateById(Long id) throws RecordNotFoundException;
	public DailySaleRateEntity createorUpdateRate(DailySaleRateEntity entity);
	public void deleteRateById(Long id) throws RecordNotFoundException;

}
