package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.ShiftDetailsEntity;
@Repository("shiftDetailsRepository")
public interface ShiftDetailsRepository extends CrudRepository<ShiftDetailsEntity, Long> {

}
