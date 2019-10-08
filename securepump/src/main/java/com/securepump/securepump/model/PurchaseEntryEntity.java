package com.securepump.securepump.model;

import java.io.Serializable;
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
@Table(name="TBL_PURCHASE_PARENT_ENTRY")
public class PurchaseEntryEntity implements Serializable {
	 private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="invoice_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date invoiceDate;
	@Column(name="bill_mode")
	private String billMode;
	@ManyToOne
	@JoinColumn(referencedColumnName = "ID")
	SupplierCreationEntity supplierCreation;

	@Column(name="supplier_invoie_num")
	private String supplierInvoiceNum;
	
	@OneToMany(mappedBy = "purchaceEntity", cascade = CascadeType.ALL)
    List<PurchaseChaildEntity> purchaseChaildEntity;
	
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getBillMode() {
		return billMode;
	}

	public void setBillMode(String billMode) {
		this.billMode = billMode;
	}

	public SupplierCreationEntity getSupplierCreation() {
		return supplierCreation;
	}

	public void setSupplierCreation(SupplierCreationEntity supplierCreation) {
		this.supplierCreation = supplierCreation;
	}

	public String getSupplierInvoiceNum() {
		return supplierInvoiceNum;
	}

	public void setSupplierInvoiceNum(String supplierInvoiceNum) {
		this.supplierInvoiceNum = supplierInvoiceNum;
	}
	
	public List<PurchaseChaildEntity> getPurchaseChaildEntity() {
		return purchaseChaildEntity;
	}

	public void setPurchaseChaildEntity(List<PurchaseChaildEntity> purchaseChaildEntity) {
		this.purchaseChaildEntity = purchaseChaildEntity;
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

	@Override
	public String toString() {
		return "PurchaseEntryEntity [id=" + id + ", invoiceDate=" + invoiceDate + ", billMode=" + billMode
				+ ", supplierCreation=" + supplierCreation + ", supplierInvoiceNum=" + supplierInvoiceNum
				+ ", purchaseChaildEntity=" + purchaseChaildEntity + ", created_by=" + created_by + ", created_date="
				+ created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date + "]";
	}
}
