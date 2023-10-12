package com.onfleet.models;

public class Vehicle {
	private String type;
	private String description;
	private String licensePlate;
	private String color;

	public Vehicle(VehicleType type, String description, String licensePlate, String color) {
		this.type = type.getValue();
		this.description = description;
		this.licensePlate = licensePlate;
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
