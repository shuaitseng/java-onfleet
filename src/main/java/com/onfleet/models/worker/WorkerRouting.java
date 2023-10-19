package com.onfleet.models.worker;

import com.onfleet.models.destination.Address;

import java.util.List;

public class WorkerRouting {
	private Address address;
	private Boolean createdByLocation;
	private String googlePlaceId;
	private String id;
	private List<Long> location;
	private String notes;
	private String organization;
	private Long timeCreated;
	private Long timeLastModified;
	private Boolean wasGeocoded;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Boolean getCreatedByLocation() {
		return createdByLocation;
	}

	public void setCreatedByLocation(Boolean createdByLocation) {
		this.createdByLocation = createdByLocation;
	}

	public String getGooglePlaceId() {
		return googlePlaceId;
	}

	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Long> getLocation() {
		return location;
	}

	public void setLocation(List<Long> location) {
		this.location = location;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
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

	public Boolean getWasGeocoded() {
		return wasGeocoded;
	}

	public void setWasGeocoded(Boolean wasGeocoded) {
		this.wasGeocoded = wasGeocoded;
	}
}
