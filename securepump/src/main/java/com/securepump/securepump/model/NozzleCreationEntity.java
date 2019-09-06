package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="NOZZLE_CREATION")
public class NozzleCreationEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nozzle_name")
	private String nozzleName;
	@Column(name="opening_meter_reading")
	private int openingMeterReading;
	@Column(name="Opening_meter_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date openingMeterDate;
	@Column(name = "created_by",updatable=false)
    private String created_by;
    @Column(name = "created_date" ,updatable=false)
    private Date created_date;
    @Column(name = "updated_by")
    private int updated_by;
    @Column(name="updated_date")
    private Date updated_date;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    TankCreationEntity tankCreation;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    UnitCreationEntity unitCreation;
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
	public TankCreationEntity getTankCreation() {
		return tankCreation;
	}
	public void setTankCreation(TankCreationEntity tankCreation) {
		this.tankCreation = tankCreation;
	}
	public UnitCreationEntity getUnitCreation() {
		return unitCreation;
	}
	public void setUnitCreation(UnitCreationEntity unitCreation) {
		this.unitCreation = unitCreation;
	}
	@Override
	public String toString() {
		return "NozzleCreationEntity [id=" + id + ", nozzleName=" + nozzleName + ", openingMeterReading="
				+ openingMeterReading + ", openingMeterDate=" + openingMeterDate + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date
				+ ", tankCreation=" + tankCreation + ", unitCreation=" + unitCreation + "]";
	}
    
    
}
