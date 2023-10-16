package com.onfleet.models;

public enum ContainerType {
	ORGANIZATION("organization"),
	TEAM("team"),
	WORKER("worker");

	private final String value;

	ContainerType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
