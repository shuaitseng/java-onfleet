package com.onfleet.models.organization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organization {
	@JsonProperty("id")
	private String id;
	@JsonProperty("timeCreated")
	private Long timeCreated;
	@JsonProperty("name")
	private String name;
	@JsonProperty("email")
	private String email;
	@JsonProperty("image")
	private String image;
	@JsonProperty("timezone")
	private String timezone;
	@JsonProperty("country")
	private String country;
	@JsonProperty("delegatees")
	private String[] delegatees;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getDelegatees() {
		return delegatees;
	}

	public void setDelegatees(String[] delegatees) {
		this.delegatees = delegatees;
	}
}
