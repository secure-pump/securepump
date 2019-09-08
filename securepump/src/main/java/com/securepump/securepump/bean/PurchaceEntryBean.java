package com.securepump.securepump.bean;

import java.util.Arrays;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PurchaceEntryBean {
	private Long id;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date invoiceDate;
	private String billMode;
	private Long supplierId;
	//private String supplierName;
	private String supplierInvoiceNum;
	private Long[] itemId;
	//private String itemName;
	private Long[] quantity;
	private Double[] rate;
	private Double[] amount;	
	private Double[] sgst;
	private Double[] cgst;
	private Double[] igst;
	private Double[] netAmt;
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
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierInvoiceNum() {
		return supplierInvoiceNum;
	}
	public void setSupplierInvoiceNum(String supplierInvoiceNum) {
		this.supplierInvoiceNum = supplierInvoiceNum;
	}
	public Long[] getItemId() {
		return itemId;
	}
	public void setItemId(Long[] itemId) {
		this.itemId = itemId;
	}
	public Long[] getQuantity() {
		return quantity;
	}
	public void setQuantity(Long[] quantity) {
		this.quantity = quantity;
	}
	public Double[] getRate() {
		return rate;
	}
	public void setRate(Double[] rate) {
		this.rate = rate;
	}
	public Double[] getAmount() {
		return amount;
	}
	public void setAmount(Double[] amount) {
		this.amount = amount;
	}
	public Double[] getSgst() {
		return sgst;
	}
	public void setSgst(Double[] sgst) {
		this.sgst = sgst;
	}
	public Double[] getCgst() {
		return cgst;
	}
	public void setCgst(Double[] cgst) {
		this.cgst = cgst;
	}
	public Double[] getIgst() {
		return igst;
	}
	public void setIgst(Double[] igst) {
		this.igst = igst;
	}
	public Double[] getNetAmt() {
		return netAmt;
	}
	public void setNetAmt(Double[] netAmt) {
		this.netAmt = netAmt;
	}
	@Override
	public String toString() {
		return "PurchaceEntryBean [id=" + id + ", invoiceDate=" + invoiceDate + ", billMode=" + billMode
				+ ", supplierId=" + supplierId + ", supplierInvoiceNum=" + supplierInvoiceNum + ", itemId="
				+ Arrays.toString(itemId) + ", quantity=" + Arrays.toString(quantity) + ", rate="
				+ Arrays.toString(rate) + ", amount=" + Arrays.toString(amount) + ", sgst=" + Arrays.toString(sgst)
				+ ", cgst=" + Arrays.toString(cgst) + ", igst=" + Arrays.toString(igst) + ", netAmt="
				+ Arrays.toString(netAmt) + "]";
	}
	
	
	
	

}
