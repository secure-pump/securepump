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
@Table(name="TBL_NOZZLE_READING_12")
public class NozzleReadingEntity {
	@Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;*/
	@Column(name="nozzle_name")
	private String nozzleName;
	@Column(name="nozzle_reading")
	private int nozzleReading;
	@Column(name="status")
	private int status;
	@Column(name="date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;
	
	/*public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}*/
	public String getNozzleName() {
		return nozzleName;
	}
	public void setNozzleName(String nozzleName) {
		this.nozzleName = nozzleName;
	}
	public int getNozzleReading() {
		return nozzleReading;
	}
	public void setNozzleReading(int nozzleReading) {
		this.nozzleReading = nozzleReading;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "NozzleReadingEntity [nozzleName=" + nozzleName + ", nozzleReading=" + nozzleReading + ", status="
				+ status + ", date=" + date + "]";
	}
	

}
