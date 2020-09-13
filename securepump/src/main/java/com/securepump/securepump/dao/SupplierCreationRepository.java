package com.securepump.securepump.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.SupplierCreationEntity;

@Repository
public interface SupplierCreationRepository extends CrudRepository<SupplierCreationEntity, Long> {

	List<SupplierCreationEntity> findBySupplierNameOrMobileNo(String supplierName,String mobileNo);
}
