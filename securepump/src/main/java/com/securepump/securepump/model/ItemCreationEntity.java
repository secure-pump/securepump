package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TBL_ITEM_CREATION")
public class ItemCreationEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name="item_name",length=2000)
	private String itemName;
	@Column(name="item_nature",length=500)
	private String itemNature;
	@Column(name="hsn_code",length=8)
	private String hsnCode;
	@Column(name="gst_percent",length=5)
	private int gstPercent;
	@Column(name="opening_stock",length=15)
	private int openingStock;
	@Column(name="Opening_stock_date")
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private Date openingStockDate;
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
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemNature() {
		return itemNature;
	}

	public void setItemNature(String itemNature) {
		this.itemNature = itemNature;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public int getGstPercent() {
		return gstPercent;
	}

	public void setGstPercent(int gstPercent) {
		this.gstPercent = gstPercent;
	}

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	public Date getOpeningStockDate() {
		return openingStockDate;
	}

	public void setOpeningStockDate(Date openingStockDate) {
		this.openingStockDate = openingStockDate;
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
		return "ItemCreationEntity [Id=" + Id + ", itemName=" + itemName + ", itemNature=" + itemNature + ", hsnCode="
				+ hsnCode + ", gstPercent=" + gstPercent + ", openingStock=" + openingStock + ", openingStockDate="
				+ openingStockDate + ", created_by=" + created_by + ", created_date=" + created_date + ", updated_by="
				+ updated_by + ", updated_date=" + updated_date + "]";
	}
    
    
}
