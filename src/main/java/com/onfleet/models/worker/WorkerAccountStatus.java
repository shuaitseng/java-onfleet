package com.onfleet.models.worker;

public enum WorkerAccountStatus {
	ACCEPTED("accepted"),
	INVITED("invited");

	private final String value;

	WorkerAccountStatus(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
