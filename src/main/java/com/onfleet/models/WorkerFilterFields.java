package com.onfleet.models;

public enum WorkerFilterFields {
	NAME("name"),
	LOCATION("location");

	private final String value;

	WorkerFilterFields(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
