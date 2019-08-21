package com.securepump.securepump.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TANK_CREATION")
public class TankCreationEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tank_name")
	private String tankName;
	@Column(name="capacity")
	private int capacity;
	@Column(name="opeingStock")
	private Long openingStock;
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
	@OneToOne
	ItemCreationEntity item;
	
	public TankCreationEntity(Long id, String tankName, int capacity, Long openingStock, String created_by,
			Date created_date, int updated_by, Date updated_date, ItemCreationEntity item) {
		super();
		this.id = id;
		this.tankName = tankName;
		this.capacity = capacity;
		this.openingStock = openingStock;
		this.created_by = created_by;
		this.created_date = created_date;
		this.updated_by = updated_by;
		this.updated_date = updated_date;
		this.item = item;
	}
	
	public TankCreationEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTankName() {
		return tankName;
	}

	public void setTankName(String tankName) {
		this.tankName = tankName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Long getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(Long openingStock) {
		this.openingStock = openingStock;
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

	public ItemCreationEntity getItem() {
		return item;
	}

	public void setItem(ItemCreationEntity item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "TankCreationEntity [id=" + id + ", tankName=" + tankName + ", capacity=" + capacity + ", openingStock="
				+ openingStock + ", created_by=" + created_by + ", created_date=" + created_date + ", updated_by="
				+ updated_by + ", updated_date=" + updated_date + ", item=" + item + "]";
	}
	
	
}
