package com.onfleet.models.task;

public enum TaskAutoAssignMode {
	DISTANCE("distance"),
	LOAD("load");

	private final String value;

	TaskAutoAssignMode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
