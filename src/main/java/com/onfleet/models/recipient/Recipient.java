package com.onfleet.models.recipient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.onfleet.models.Metadata;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipient {
	private String id;
	private String name;
	private String phone;
	private String notes;
	private Boolean skipSMSNotifications;
	private long timeCreated;
	private long timeLastModified;
	private String organization;
	private List<Metadata> metadata;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getSkipSMSNotifications() {
		return skipSMSNotifications;
	}

	public void setSkipSMSNotifications(Boolean skipSMSNotifications) {
		this.skipSMSNotifications = skipSMSNotifications;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
}
