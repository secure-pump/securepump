package com.securepump.securepump.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class NozzleCreationBean {
	
	private Long id;
	private String nozzleName;
	private int openingMeterReading;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date openingMeterDate;
	private String created_by;
	private Date created_date;
	private int updated_by;
	private Date updated_date;
	private Long tankId;
	private String tankName;
	private Long unitId;
	private String unitName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNozzleName() {
		return nozzleName;
	}
	public void setNozzleName(String nozzleName) {
		this.nozzleName = nozzleName;
	}
	public int getOpeningMeterReading() {
		return openingMeterReading;
	}
	public void setOpeningMeterReading(int openingMeterReading) {
		this.openingMeterReading = openingMeterReading;
	}
	public Date getOpeningMeterDate() {
		return openingMeterDate;
	}
	public void setOpeningMeterDate(Date openingMeterDate) {
		this.openingMeterDate = openingMeterDate;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
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
	public Long getTankId() {
		return tankId;
	}
	public void setTankId(Long tankId) {
		this.tankId = tankId;
	}
	public String getTankName() {
		return tankName;
	}
	public void setTankName(String tankName) {
		this.tankName = tankName;
	}
	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	@Override
	public String toString() {
		return "NozzleCreationBean [id=" + id + ", nozzleName=" + nozzleName + ", openingMeterReading="
				+ openingMeterReading + ", openingMeterDate=" + openingMeterDate + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date
				+ ", tankId=" + tankId + ", tankName=" + tankName + ", unitId=" + unitId + ", unitName=" + unitName
				+ "]";
	}
	
}
