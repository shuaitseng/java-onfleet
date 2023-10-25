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

	public Long getTimeCreated() {
		return timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getDriverSupportEmail() {
		return driverSupportEmail;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getImage() {
		return image;
	}

	public String getCountry() {
		return country;
	}

	public List<String> getDelegatees() {
		return delegatees;
	}
}
