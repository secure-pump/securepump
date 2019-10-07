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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TBL_DAILY_SALE_RATE")
public class DailySaleRateEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Daily_sale_rate") 
	private Long dailySaleRate;
	@Column(name="Date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;
	@Column(name = "created_by",updatable=false)
    private String created_by;
    
    @Column(name = "created_date" ,updatable=false)
    private Date created_date;
    
    @Column(name = "updated_by")
    private String updated_by;
    
    @Column(name="updated_date")
    private Date updated_date;
	@ManyToOne
    @JoinColumn(referencedColumnName = "ID")
	ItemCreationEntity itemCreation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDailySaleRate() {
		return dailySaleRate;
	}
	public void setDailySaleRate(Long dailySaleRate) {
		this.dailySaleRate = dailySaleRate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public ItemCreationEntity getItemCreation() {
		return itemCreation;
	}
	public void setItemCreation(ItemCreationEntity itemCreation) {
		this.itemCreation = itemCreation;
	}
	@Override
	public String toString() {
		return "DailySaleRateEntity [id=" + id + ", dailySaleRate=" + dailySaleRate + ", date=" + date + ", created_by="
				+ created_by + ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date="
				+ updated_date + ", itemCreation=" + itemCreation + "]";
	}

	
}
