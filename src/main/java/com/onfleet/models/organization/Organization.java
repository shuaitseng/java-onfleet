package com.onfleet.models.organization;


import java.util.List;

public class Organization {
	private String id;
	private Long timeCreated;
	private Long timeLastModified;
	private String name;
	private String email;
	private String driverSupportEmail;
	private String timezone;
	private String image;
	private String country;
	private List<String> delegatees;

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

	public String getDriverSupportEmail() {
		return driverSupportEmail;
	}

	public void setDriverSupportEmail(String driverSupportEmail) {
		this.driverSupportEmail = driverSupportEmail;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getDelegatees() {
		return delegatees;
	}

	public void setDelegatees(List<String> delegatees) {
		this.delegatees = delegatees;
	}
}
