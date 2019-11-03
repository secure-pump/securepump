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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Tbl_shift_credit_cust_dtls")
public class ShiftCreditCustomerDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="vehicle_no")
	private String vehicleNo;
	@Column(name="InvoiceNo",unique=true)
	private String invoiceNo;
	@Column(name="date")
	private Date date;
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
	private ShiftDetailsEntity shiftdetails;
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
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ShiftDetailsEntity getShiftdetails() {
		return shiftdetails;
	}
	public void setShiftdetails(ShiftDetailsEntity shiftdetails) {
		this.shiftdetails = shiftdetails;
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
		return "ShiftCreditCustomerDetails [id=" + id + ", vehicleNo=" + vehicleNo + ", invoiceNo=" + invoiceNo
				+ ", date=" + date + ", shiftdetails=" + shiftdetails + ", created_date=" + created_date
				+ ", created_by=" + created_by + ", updated_by=" + updated_by + ", updated_date=" + updated_date + "]";
	}
	

}
