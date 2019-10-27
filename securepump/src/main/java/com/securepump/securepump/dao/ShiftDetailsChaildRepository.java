package com.securepump.securepump.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.ShiftDetailsChaildEntity;

@Repository("shiftDetailsChaildRepository")
public interface ShiftDetailsChaildRepository extends CrudRepository<ShiftDetailsChaildEntity, Long> {

}
