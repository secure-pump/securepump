package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_BOY_CREATION")
public class BoyCreationEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		@Column(name="boy_name")
		private String boyName;
		@Column(name="mobile_no",length=15)
		private String mobileNo;
		@Column(name="address1")
		private String address1;
		@Column(name="address2")
		private String address2;
		@Column(name="salary",length=15)
		private String salary;
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

		public String getBoyName() {
			return boyName;
		}

		public void setBoyName(String boyName) {
			this.boyName = boyName;
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

		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
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
			return "BoyCreationEntity [Id=" + Id + ", boyName=" + boyName + ", MobileNo=" + mobileNo + ", address1="
					+ address1 + ", address2=" + address2 + ", salary=" + salary + ", created_by=" + created_by
					+ ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date
					+ "]";
		}
		
}
