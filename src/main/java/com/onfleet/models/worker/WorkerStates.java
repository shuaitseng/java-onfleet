package com.onfleet.models.worker;

public enum WorkerStates {
	OFF_DUTY(0),
	IDLE(1),
	ACTIVE(2);

	private final int value;

	WorkerStates(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
