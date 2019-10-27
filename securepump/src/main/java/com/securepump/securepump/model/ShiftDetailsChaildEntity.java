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

@Entity
@Table(name="TBL_SHIFTDETAILS_CHAILD_12")
public class ShiftDetailsChaildEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "item_nature")
	String itemNature;
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
	UnitCreationEntity unitCreation;
	@ManyToOne
    @JoinColumn(referencedColumnName = "nozzle_name")
	NozzleReadingEntity nozzleReadingName;
	@Column(name = "openReading")
	private Long openReading;
	@Column(name = "closeReading")
	private Long closeReading;
	@Column(name = "testReading")
	private Long testReading;
	@Column(name = "saleStock")
	private Long saleStock;
	@Column(name = "rate")
	private Long rate;
	@Column(name = "totalAmt")
	private Long totalAmt;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	ShiftDetailsEntity shiftDetailsEntity;
	
	@Column(name = "created_date" ,updatable=false)
	private Date created_date;
	
	@Column(name = "created_by",updatable=false)
	private String created_by;
	    
	@Column(name = "updated_by")
	private String updated_by;
	    
	@Column(name="updated_date")
	private Date updated_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemNature() {
		return itemNature;
	}

	public void setItemNature(String itemNature) {
		this.itemNature = itemNature;
	}

	public UnitCreationEntity getUnitCreation() {
		return unitCreation;
	}

	public void setUnitCreation(UnitCreationEntity unitCreation) {
		this.unitCreation = unitCreation;
	}

	public NozzleReadingEntity getNozzleReadingName() {
		return nozzleReadingName;
	}

	public void setNozzleReadingName(NozzleReadingEntity nozzleReadingName) {
		this.nozzleReadingName = nozzleReadingName;
	}

	public Long getOpenReading() {
		return openReading;
	}

	public void setOpenReading(Long openReading) {
		this.openReading = openReading;
	}

	public Long getCloseReading() {
		return closeReading;
	}

	public void setCloseReading(Long closeReading) {
		this.closeReading = closeReading;
	}

	public Long getTestReading() {
		return testReading;
	}

	public void setTestReading(Long testReading) {
		this.testReading = testReading;
	}

	public Long getSaleStock() {
		return saleStock;
	}

	public void setSaleStock(Long saleStock) {
		this.saleStock = saleStock;
	}

	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	public Long getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Long totalAmt) {
		this.totalAmt = totalAmt;
	}

	public ShiftDetailsEntity getShiftDetailsEntity() {
		return shiftDetailsEntity;
	}

	public void setShiftDetailsEntity(ShiftDetailsEntity shiftDetailsEntity) {
		this.shiftDetailsEntity = shiftDetailsEntity;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
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
		return "ShiftDetailsChaildEntity [id=" + id + ", itemNature=" + itemNature + ", unitCreation=" + unitCreation
				+ ", nozzleReadingName=" + nozzleReadingName + ", openReading=" + openReading + ", closeReading="
				+ closeReading + ", testReading=" + testReading + ", saleStock=" + saleStock + ", rate=" + rate
				+ ", totalAmt=" + totalAmt + ", shiftDetailsEntity=" + shiftDetailsEntity + ", created_date="
				+ created_date + ", created_by=" + created_by + ", updated_by=" + updated_by + ", updated_date="
				+ updated_date + "]";
	}

	


}
