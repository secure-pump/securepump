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
@Table(name="tbl_shift_credit_cust_itm_details")
public class ShiftCreditCustItemDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="quantity")
	private Long quantity;
	@Column(name="rate")
	private Long rate;
	@Column(name="amount")
	private float amount;
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
	ItemCreationEntity itemEntity;
	@ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
	ShiftCreditCustomerDetailsEntity creditCustomerDetails;
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
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getRate() {
		return rate;
	}
	public void setRate(Long rate) {
		this.rate = rate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public ItemCreationEntity getItemEntity() {
		return itemEntity;
	}
	public void setItemEntity(ItemCreationEntity itemEntity) {
		this.itemEntity = itemEntity;
	}
	public ShiftCreditCustomerDetailsEntity getCreditCustomerDetails() {
		return creditCustomerDetails;
	}
	public void setCreditCustomerDetails(ShiftCreditCustomerDetailsEntity creditCustomerDetails) {
		this.creditCustomerDetails = creditCustomerDetails;
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
	@Override
	public String toString() {
		return "ShiftCreditCustItemDetailsEntity [id=" + id + ", quantity=" + quantity + ", rate=" + rate + ", amount="
				+ amount + ", itemEntity=" + itemEntity + ", creditCustomerDetails=" + creditCustomerDetails
				+ ", created_date=" + created_date + ", created_by=" + created_by + ", updated_by=" + updated_by
				+ ", updated_date=" + updated_date + "]";
	}
	
}
