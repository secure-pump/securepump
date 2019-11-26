package com.securepump.securepump.bean;

import java.io.Serializable;

public class ShiftDetailsChaildRestVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long shiftChaildId;
	String itemNature;
	//UnitCreationEntity unitCreation;
	private Long unitId;
	private String unitName;
	
	//NozzleReadingEntity nozzleReadingName;
	private String nozzleName;
	private int nozzleReading;
	private int status;
	
	private Long openReading;
	private Long closeReading;
	private Long testReading;
	private Long saleStock;
	private Long rate;
	private Long totalAmt;
	public Long getShiftChaildId() {
		return shiftChaildId;
	}
	public void setShiftChaildId(Long shiftChaildId) {
		this.shiftChaildId = shiftChaildId;
	}
	public String getItemNature() {
		return itemNature;
	}
	public void setItemNature(String itemNature) {
		this.itemNature = itemNature;
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
	public String getNozzleName() {
		return nozzleName;
	}
	public void setNozzleName(String nozzleName) {
		this.nozzleName = nozzleName;
	}
	public int getNozzleReading() {
		return nozzleReading;
	}
	public void setNozzleReading(int nozzleReading) {
		this.nozzleReading = nozzleReading;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "ShiftDetailsChaildRestVO [shiftChaildId=" + shiftChaildId + ", itemNature=" + itemNature + ", unitId="
				+ unitId + ", unitName=" + unitName + ", nozzleName=" + nozzleName + ", nozzleReading=" + nozzleReading
				+ ", status=" + status + ", openReading=" + openReading + ", closeReading=" + closeReading
				+ ", testReading=" + testReading + ", saleStock=" + saleStock + ", rate=" + rate + ", totalAmt="
				+ totalAmt + "]";
	}
	
	
	

}
