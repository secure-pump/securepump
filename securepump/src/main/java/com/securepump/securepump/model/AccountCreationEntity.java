package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ACCOUNT_CREATION")
public class AccountCreationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="account_name")
    private String actName;
    
    @Column(name="account_type",nullable=false)
    private String actType;
    
    @Column(name="account_group", nullable=false, length=200)
    private String actGroup;
    
    @Column(name = "created_by",updatable=false)
    private int created_by;
    
    @Column(name = "created_date" ,updatable=false)
    //@ColumnTransformer(write="Coalesce(Current_Timestamp, ?)")
    private Date created_date;
    
    @Column(name = "updated_by")
    private int updated_by;
    
    @Column(name="updated_date")
   // @ColumnTransformer(write="Coalesce(Current_Timestamp, ?)")
    private Date updated_date;

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActType() {
		return actType;
	}

	public void setActType(String actType) {
		this.actType = actType;
	}

	public String getActGroup() {
		return actGroup;
	}

	public void setActGroup(String actGroup) {
		this.actGroup = actGroup;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
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
		return "AccountCreationEntity [id=" + id + ", actName=" + actName + ", actType=" + actType + ", actGroup="
				+ actGroup + "]";
	}
	

}