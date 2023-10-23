package com.onfleet.models.task;

public enum TaskState {
	UNASSIGNED(0),
	ASSIGNED(1),
	ACTIVE(2),
	COMPLETED(3);

	private final int value;

	TaskState(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
