package com.securepump.securepump.bean;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PurchaceEntryRestVO implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date invoiceDate;
	private String billMode;
	private Long supplierID;
	private String supplierName;
	private String supplierInvoiceNum;
    List<PurchaseChaildRestVo> purchaseChaildRestVo;
    private String created_by;
    private Date created_date;
    private String updated_by;
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

	public Long getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Long supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierInvoiceNum() {
		return supplierInvoiceNum;
	}

	public void setSupplierInvoiceNum(String supplierInvoiceNum) {
		this.supplierInvoiceNum = supplierInvoiceNum;
	}

	public List<PurchaseChaildRestVo> getPurchaseChaildRestVo() {
		return purchaseChaildRestVo;
	}

	public void setPurchaseChaildRestVo(List<PurchaseChaildRestVo> purchaseChaildRestVo) {
		this.purchaseChaildRestVo = purchaseChaildRestVo;
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
		return "PurchaceEntryRestVO [id=" + id + ", invoiceDate=" + invoiceDate + ", billMode=" + billMode
				+ ", supplierID=" + supplierID + ", supplierName=" + supplierName + ", supplierInvoiceNum="
				+ supplierInvoiceNum + ", purchaseChaildRestVo=" + purchaseChaildRestVo + ", created_by=" + created_by
				+ ", created_date=" + created_date + ", updated_by=" + updated_by + ", updated_date=" + updated_date
				+ "]";
	}
	
	
}

