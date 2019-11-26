package com.securepump.securepump.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class ShiftDetailsRestVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long shiftDetailsId;
	private Long boyId;
	private int mobileNo;
	private Date shiftDetailsDate;
	private boolean shiftStatus;
	private Double totalAmount;
	List<ShiftDetailsChaildRestVO> shiftDetailsChaildRestVO;
	private String created_by;
	private Date created_date;
	private String updated_by;
	private Date updated_date;
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
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getShiftDetailsDate() {
		return shiftDetailsDate;
	}
	public void setShiftDetailsDate(Date shiftDetailsDate) {
		this.shiftDetailsDate = shiftDetailsDate;
	}
	public List<ShiftDetailsChaildRestVO> getShiftDetailsChaildRestVO() {
		return shiftDetailsChaildRestVO;
	}
	public void setShiftDetailsChaildRestVO(List<ShiftDetailsChaildRestVO> shiftDetailsChaildRestVO) {
		this.shiftDetailsChaildRestVO = shiftDetailsChaildRestVO;
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
		return "ShiftDetailsRestVO [shiftDetailsId=" + shiftDetailsId + ", boyId=" + boyId + ", mobileNo=" + mobileNo
				+ ", shiftDetailsDate=" + shiftDetailsDate + ", shiftStatus=" + shiftStatus + ", totalAmount="
				+ totalAmount + ", shiftDetailsChaildRestVO=" + shiftDetailsChaildRestVO + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date
				+ "]";
	}
	
	

}
