package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Administrator {
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("isReadOnly")
	private Boolean isReadOnly;
	@JsonProperty("type")
	private Type type;

	public Administrator(String name, String email, String phone, Boolean isReadOnly, Type type) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isReadOnly = isReadOnly;
		this.type = type;
	}

	public enum Type {
		SUPER("super"),
		STANDARD("standard");
		private final String stringValue;

		Type(String stringValue) {
			this.stringValue = stringValue;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		isReadOnly = readOnly;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}