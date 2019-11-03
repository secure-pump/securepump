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
@Table(name="Tbl_Shift_Settlement_Details")
public class ShiftSettlementDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="group_name")
	private String group;
	@Column(name="mode")
	private String mode;
	@Column(name="amount")
	private int amount;
	@Column(name="date")
	private Date date;
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
	private CustomerCreationEntity customerDetails;
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
	private ShiftDetailsEntity shiftDetails;
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

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public CustomerCreationEntity getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerCreationEntity customerDetails) {
		this.customerDetails = customerDetails;
	}

	public ShiftDetailsEntity getShiftDetails() {
		return shiftDetails;
	}

	public void setShiftDetails(ShiftDetailsEntity shiftDetails) {
		this.shiftDetails = shiftDetails;
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
		return "ShiftSettlementDetails [id=" + id + ", group=" + group + ", mode=" + mode + ", amount=" + amount
				+ ", date=" + date + ", customerDetails=" + customerDetails + ", shiftDetails=" + shiftDetails
				+ ", created_date=" + created_date + ", created_by=" + created_by + ", updated_by=" + updated_by
				+ ", updated_date=" + updated_date + "]";
	}

	
	
	
}
