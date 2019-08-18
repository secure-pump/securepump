package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_SUPPLIER_CREATION")
public class SupplierCreationEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="supplier_ame",length=250)
	private String supplierName;
	@Column(name="mobile_no",length=15)
	private String mobileNo;
	@Column(name="address1",length=1000)
	private String address1;
	@Column(name="address2",length=1000)
	private String address2;
	@Column(name="gstno",length=1000)
	private String gstNo;
	@Column(name="opening_Bal")
	private Long openingBal;
	@Column(name = "created_by",updatable=false)
    private String created_by;
    
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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Long getOpeningBal() {
		return openingBal;
	}

	public void setOpeningBal(Long openingBal) {
		this.openingBal = openingBal;
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

	@Override
	public String toString() {
		return "SupplierCreationEntity [id=" + id + ", supplierName=" + supplierName + ", mobileNo=" + mobileNo
				+ ", address1=" + address1 + ", address2=" + address2 + ", gstNo=" + gstNo + ", openingBal="
				+ openingBal + ", created_by=" + created_by + ", created_date=" + created_date + ", updated_by="
				+ updated_by + ", updated_date=" + updated_date + "]";
	}
    
    
}
