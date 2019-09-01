package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_CUSTOMER_CREATION")
public class CustomerCreationEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		@Column(name="customer_name")
		private String customerName;
		@Column(name="mobile_no")
		private String mobileNo;
		@Column(name="address1")
		private String address1;
		@Column(name="address2")
		private String address2;
		@Column(name="gstno",length=15)
		private String gstNo;
		@Column(name="credit_limit",length=25)
		private int creditLimit;
		@Column(name="due_days",length=25)
		private int dueDays;
		@Column(name="opening_bal",length=25)
		private int openingBal;
		@Column(name="opening_bal_date")
		private Date openingBalDate;
		@Column(name = "created_by",updatable=false)
	    private String  created_by;
		@Column(name = "created_date" ,updatable=false)
		private Date created_date;
		@Column(name = "updated_by")
		private int updated_by;
		@Column(name="updated_date")
		private Date updated_date;
		public Long getId() {
			return Id;
		}
		public void setId(Long id) {
			Id = id;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
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
		public int getCreditLimit() {
			return creditLimit;
		}
		public void setCreditLimit(int creditLimit) {
			this.creditLimit = creditLimit;
		}
		public int getDueDays() {
			return dueDays;
		}
		public void setDueDays(int dueDays) {
			this.dueDays = dueDays;
		}
		public int getOpeningBal() {
			return openingBal;
		}
		public void setOpeningBal(int openingBal) {
			this.openingBal = openingBal;
		}
		public Date getOpeningBalDate() {
			return openingBalDate;
		}
		public void setOpeningBalDate(Date openingBalDate) {
			this.openingBalDate = openingBalDate;
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
			return "CustomerCreationEntity [Id=" + Id + ", customerName=" + customerName + ", MobileNo=" + mobileNo
					+ ", address1=" + address1 + ", address2=" + address2 + ", gstNo=" + gstNo + ", creditLimit="
					+ creditLimit + ", dueDays=" + dueDays + ", openingBal=" + openingBal + ", openingBalDate="
					+ openingBalDate + ", created_by=" + created_by + ", created_date=" + created_date + ", updated_by="
					+ updated_by + ", updated_date=" + updated_date + "]";
		}
		
		
		

}
