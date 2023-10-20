package com.onfleet.models.administrator;

public enum AdministratorType {
	SUPER("super"),
	STANDARD("standard");
	private final String stringValue;

	AdministratorType(String stringValue) {
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
