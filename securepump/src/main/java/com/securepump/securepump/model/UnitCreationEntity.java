package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_UNIT_CREATION")
public class UnitCreationEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="unit_name")
	private String unitName;
	@Column(name = "created_date" ,updatable=false)
	    //@ColumnTransformer(write="Coalesce(Current_Timestamp, ?)")
	private Date created_date;
	    
	@Column(name = "updated_by")
	private int updated_by;
	    
	@Column(name="updated_date")
	   // @ColumnTransformer(write="Coalesce(Current_Timestamp, ?)")
	private Date updated_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public int getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	@Override
	public String toString() {
		return "UnitCreationEntity [id=" + id + ", unitName=" + unitName + ", created_date=" + created_date
				+ ", updated_by=" + updated_by + ", updated_date=" + updated_date + "]";
	}
	
	
	
	
}
