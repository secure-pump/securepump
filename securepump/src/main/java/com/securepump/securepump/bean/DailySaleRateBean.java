package com.securepump.securepump.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DailySaleRateBean {
	private Long id;
	private Long dailySaleRate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date; 
	private String created_by;
	private Date created_date;
	private String updated_by;
	private Date updated_date;
	private Long itemId;
	private String itemName;
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
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "DailySaleRateBean [id=" + id + ", dailySaleRate=" + dailySaleRate + ", date=" + date + ", created_by="
				+ created_by + ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date="
				+ updated_date + ", itemId=" + itemId + ", itemName=" + itemName + "]";
	}
	

}
