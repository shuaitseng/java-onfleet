package com.onfleet.models;

public enum VehicleType {
	CAR("CAR"),
	MOTORCYCLE("MOTORCYCLE"),
	BICYCLE("BICYCLE"),
	TRUCK("TRUCK");

	private final String value;

	VehicleType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
