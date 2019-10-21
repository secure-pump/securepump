package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="TBL_UNIT_CREATION")
public class ShiftDetailsEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="unit_name")
	private String unitName;
	@Column(name = "created_date" ,updatable=false)
	private Date created_date;
	    
	@Column(name = "updated_by")
	private int updated_by;
	    
	@Column(name="updated_date")
	private Date updated_date;

}
