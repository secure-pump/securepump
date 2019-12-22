package com.securepump.securepump.bean;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ShiftDetailsBean {
	private Long shiftDetailsId;
	private Long boyId;
	private Long mobileNo;
	private boolean shiftStatus;
	private Double totalAmount;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date shiftDetailsDate;
	private Long[] shiftChaildId;
	private String[] itemNature;
	private Long[] unitId;
	private String[] nozzleName;
	private Long[] openReading;
	private Long[] closeReading;
	private Long[] testReading;
	private Long[] saleStock;
	private Long[] rate;
	private Long[] totalAmt;
	public Long getShiftDetailsId() {
		return shiftDetailsId;
	}
	public void setShiftDetailsId(Long shiftDetailsId) {
		this.shiftDetailsId = shiftDetailsId;
	}
	public Long getBoyId() {
		return boyId;
	}
	public void setBoyId(Long boyId) {
		this.boyId = boyId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getShiftDetailsDate() {
		return shiftDetailsDate;
	}
	public void setShiftDetailsDate(Date shiftDetailsDate) {
		this.shiftDetailsDate = shiftDetailsDate;
	}
	
	public Long[] getShiftChaildId() {
		return shiftChaildId;
	}
	public void setShiftChaildId(Long[] shiftChaildId) {
		this.shiftChaildId = shiftChaildId;
	}
	public String[] getItemNature() {
		return itemNature;
	}
	public void setItemNature(String[] itemNature) {
		this.itemNature = itemNature;
	}
	public Long[] getUnitId() {
		return unitId;
	}
	public void setUnitId(Long[] unitId) {
		this.unitId = unitId;
	}
	public String[] getNozzleName() {
		return nozzleName;
	}
	public void setNozzleName(String[] nozzleName) {
		this.nozzleName = nozzleName;
	}
	public Long[] getOpenReading() {
		return openReading;
	}
	public void setOpenReading(Long[] openReading) {
		this.openReading = openReading;
	}
	public Long[] getCloseReading() {
		return closeReading;
	}
	public void setCloseReading(Long[] closeReading) {
		this.closeReading = closeReading;
	}
	public Long[] getTestReading() {
		return testReading;
	}
	public void setTestReading(Long[] testReading) {
		this.testReading = testReading;
	}
	public Long[] getSaleStock() {
		return saleStock;
	}
	public void setSaleStock(Long[] saleStock) {
		this.saleStock = saleStock;
	}
	public Long[] getRate() {
		return rate;
	}
	public void setRate(Long[] rate) {
		this.rate = rate;
	}
	public Long[] getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Long[] totalAmt) {
		this.totalAmt = totalAmt;
	}
	public boolean isShiftStatus() {
		return shiftStatus;
	}
	public void setShiftStatus(boolean shiftStatus) {
		this.shiftStatus = shiftStatus;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "ShiftDetailsBean [shiftDetailsId=" + shiftDetailsId + ", boyId=" + boyId + ", mobileNo=" + mobileNo
				+ ", shiftStatus=" + shiftStatus + ", totalAmount=" + totalAmount + ", shiftDetailsDate="
				+ shiftDetailsDate + ", shiftChaildId=" + Arrays.toString(shiftChaildId) + ", itemNature="
				+ Arrays.toString(itemNature) + ", unitId=" + Arrays.toString(unitId) + ", nozzleName="
				+ Arrays.toString(nozzleName) + ", openReading=" + Arrays.toString(openReading) + ", closeReading="
				+ Arrays.toString(closeReading) + ", testReading=" + Arrays.toString(testReading) + ", saleStock="
				+ Arrays.toString(saleStock) + ", rate=" + Arrays.toString(rate) + ", totalAmt="
				+ Arrays.toString(totalAmt) + "]";
	}
	

}
