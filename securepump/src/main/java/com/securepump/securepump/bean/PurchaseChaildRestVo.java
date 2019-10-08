package com.securepump.securepump.bean;

public class PurchaseChaildRestVo {

	private Long purchaceChaildId;
	private Long itemId;
	private String itemName;
	private String itemNature;
	private Long quantity;
	private Double rate;
	private Double amount;
	private Double sgst;
	private Double cgst;
	private Double igst;
	private Double netAmt;
	
	public Long getPurchaceChaildId() {
		return purchaceChaildId;
	}

	public void setPurchaceChaildId(Long purchaceChaildId) {
		this.purchaceChaildId = purchaceChaildId;
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

	public String getItemNature() {
		return itemNature;
	}

	public void setItemNature(String itemNature) {
		this.itemNature = itemNature;
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

	@Override
	public String toString() {
		return "PurchaseChaildRestVo [purchaceChaildId=" + purchaceChaildId + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemNature=" + itemNature + ", quantity=" + quantity + ", rate=" + rate + ", amount="
				+ amount + ", sgst=" + sgst + ", cgst=" + cgst + ", igst=" + igst + ", netAmt=" + netAmt + "]";
	}

}
