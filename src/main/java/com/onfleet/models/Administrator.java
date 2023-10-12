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
	private String id;
	private Long timeCreated;
	private Long timeLastModified;
	private String organization;
	@JsonProperty("isActive")
	private Boolean isActive;
	private String[] metadata;
	@JsonProperty("isAccountOwner")
	private Boolean isAccountOwner;
	private String[] teams;

	public Administrator() {
	}

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

		public String getStringValue() {
			return stringValue;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(Long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}

	public String[] getMetadata() {
		return metadata;
	}

	public void setMetadata(String[] metadata) {
		this.metadata = metadata;
	}

	public Boolean isAccountOwner() {
		return isAccountOwner;
	}

	public void setAccountOwner(boolean accountOwner) {
		isAccountOwner = accountOwner;
	}

	public String[] getTeams() {
		return teams;
	}

	public void setTeams(String[] teams) {
		this.teams = teams;
	}
}