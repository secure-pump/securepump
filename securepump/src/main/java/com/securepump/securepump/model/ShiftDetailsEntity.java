package com.securepump.securepump.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TBL_SHIFTDETAILS_PARENT_1")
public class ShiftDetailsEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(referencedColumnName = "ID")
	BoyCreationEntity boyCreation;
	
	@Column(name="shiftdetails_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date shiftDetailsDate;
	
	@OneToMany(mappedBy = "shiftDetailsEntity", cascade = CascadeType.ALL)
    List<ShiftDetailsChaildEntity> shiftDetailsChaildEntity;
	
	private boolean shiftStatus;
	
	private Double totalAmount;
	
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

	public BoyCreationEntity getBoyCreation() {
		return boyCreation;
	}

	public void setBoyCreation(BoyCreationEntity boyCreation) {
		this.boyCreation = boyCreation;
	}

	public Date getShiftDetailsDate() {
		return shiftDetailsDate;
	}

	public void setShiftDetailsDate(Date shiftDetailsDate) {
		this.shiftDetailsDate = shiftDetailsDate;
	}

	public List<ShiftDetailsChaildEntity> getShiftDetailsChaildEntity() {
		return shiftDetailsChaildEntity;
	}

	public void setShiftDetailsChaildEntity(List<ShiftDetailsChaildEntity> shiftDetailsChaildEntity) {
		this.shiftDetailsChaildEntity = shiftDetailsChaildEntity;
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
		return "ShiftDetailsEntity [id=" + id + ", boyCreation=" + boyCreation + ", shiftDetailsDate="
				+ shiftDetailsDate + ", shiftDetailsChaildEntity=" + shiftDetailsChaildEntity + ", shiftStatus="
				+ shiftStatus + ", totalAmount=" + totalAmount + ", created_date=" + created_date + ", created_by="
				+ created_by + ", updated_by=" + updated_by + ", updated_date=" + updated_date + "]";
	}


	
	

}
