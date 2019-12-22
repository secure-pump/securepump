package com.securepump.securepump.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.securepump.securepump.model.ShiftDetailsEntity;
@Repository("shiftDetailsRepository")
public interface ShiftDetailsRepository extends CrudRepository<ShiftDetailsEntity, Long> {
	@Query(value="select daily_sale_rate,date from stixsu5_securepump.tbl_daily_sale_rate where item_creation_id=(select item_creation_id from tank_creation where id=(select tank_creation_id from  stixsu5_securepump.nozzle_creation where nozzle_name=?1)) and DATE_FORMAT(date,'%d-%m-%Y')= ?2",nativeQuery=true)
	public Double getSalePrice(String nozzleName, String date);

}
