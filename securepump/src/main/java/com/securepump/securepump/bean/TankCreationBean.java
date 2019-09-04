package com.securepump.securepump.bean;

import java.util.Date;

public class TankCreationBean {
	private Long id;
	private String tankName;
	private int capacity;
	private Long openingStock;
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
	public String getTankName() {
		return tankName;
	}
	public void setTankName(String tankName) {
		this.tankName = tankName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Long getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(Long openingStock) {
		this.openingStock = openingStock;
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
		return "TankCreationBean [id=" + id + ", tankName=" + tankName + ", capacity=" + capacity + ", openingStock="
				+ openingStock + ", created_by=" + created_by + ", created_date=" + created_date + ", updated_by="
				+ updated_by + ", updated_date=" + updated_date + ", itemId=" + itemId + ", itemName=" + itemName + "]";
	}
	
	

}
