package com.vehicle.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="vehicle",uniqueConstraints = { @UniqueConstraint(columnNames = "vehicle_id")})
public class Vehicle {
	
	
	@Id
	@GeneratedValue
	@Column(name="vehicle_id")
	private	Integer id;
	
	@Column(name="vehicle_name")
	private String vehiclename;
	
	@Column(name="vehicle_brand")
	private String brand;
	
	@Column(name="vehicle_model")
	private String model;
	
	@Column(name="vehicle_type")
	private String type;
	
	@Column(name="vehicle_lattitude")
	private Double lattitude;
	
	@Column(name="vehicle_longitude")
	private Double longitude;
	
	@Column(name="vehicle_user")
	private String username;
	
	
	public Vehicle() {
		
	}
	
	public Vehicle(String vehiclename,String brand,String model,String type,Double lattitude,Double longitude,String username) {
		this.vehiclename=vehiclename;
		this.brand=brand;
		this.model=model;
		this.lattitude=lattitude;
		this.type=type;
		this.longitude=longitude;
		this.username=username;
		
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getLattitude() {
		return lattitude;
	}
	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
