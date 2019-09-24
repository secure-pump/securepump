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
@Table(name="TBL_PURCHASE_CHAILD_ENTRY")
public class PurchaseChaildEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "ID")
	ItemCreationEntity itemCreation;
	
	@Column(name="quantity")
	private Long quantity;
	@Column(name="rate")
	private Double rate;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="sgst")
	private Double sgst;
	@Column(name="cgst")
	private Double cgst;
	@Column(name="igst")
	private Double igst;
	@Column(name="net_amount")
	private Double netAmt;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "ID")
	PurchaseEntryEntity purchaceEntity;
	
	@Column(name = "created_by",updatable=false)
    private String created_by;
    
    @Column(name = "created_date" ,updatable=false)
    private Date created_date;
    
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

	
	public ItemCreationEntity getItemCreation() {
		return itemCreation;
	}

	public void setItemCreation(ItemCreationEntity itemCreation) {
		this.itemCreation = itemCreation;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public Double getNetAmt() {
		return netAmt;
	}

	public void setNetAmt(Double netAmt) {
		this.netAmt = netAmt;
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
	
	public PurchaseEntryEntity getPurchaceEntity() {
		return purchaceEntity;
	}

	public void setPurchaceEntity(PurchaseEntryEntity purchaceEntity) {
		this.purchaceEntity = purchaceEntity;
	}

	@Override
	public String toString() {
		return "PurchaseChaildEntity [id=" + id + ", itemCreation=" + itemCreation + ", quantity=" + quantity
				+ ", rate=" + rate + ", amount=" + amount + ", sgst=" + sgst + ", cgst=" + cgst + ", igst=" + igst
				+ ", netAmt=" + netAmt + ", purchaceEntity=" + purchaceEntity + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date
				+ "]";
	}

	


    
    
	


}
