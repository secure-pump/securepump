package com.securepump.securepump.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.ItemCreationEntity;

@Repository
public interface ItemCreationRepository extends CrudRepository<ItemCreationEntity, Long>{
	@Async
	List<ItemCreationEntity> findByItemNature(String itemNature);

}
