package com.securepump.model;

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

	@Override
	public String toString() {
		return "AccountCreationEntity [id=" + id + ", actName=" + actName + ", actType=" + actType + ", actGroup="
				+ actGroup + "]";
	}
	

}