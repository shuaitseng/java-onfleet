package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipient {
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("skipSMSNotifications")
	private Boolean skipSMSNotifications;
	@JsonProperty("skipPhoneNumberValidation")
	private Boolean skipPhoneNumberValidation;
	@JsonProperty("useLongCodeForText")
	private Boolean useLongCodeForText;
	private long timeCreated;
	private long timeLastModified;
	private String organization;
	private List<Metadata> metadata;

	public Recipient() {
	}

	public Recipient(String name, String phone, Boolean useLongCodeForText) {
		this.name = name;
		this.phone = phone;
		this.useLongCodeForText = useLongCodeForText;
	}

	public Recipient(String name, String phone, String notes, Boolean skipSMSNotifications, Boolean skipPhoneNumberValidation, Boolean useLongCodeForText) {
		this(name, phone, useLongCodeForText);
		this.notes = notes;
		this.skipSMSNotifications = skipSMSNotifications;
		this.skipPhoneNumberValidation = skipPhoneNumberValidation;
	}

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

	public Boolean getSkipPhoneNumberValidation() {
		return skipPhoneNumberValidation;
	}

	public void setSkipPhoneNumberValidation(Boolean skipPhoneNumberValidation) {
		this.skipPhoneNumberValidation = skipPhoneNumberValidation;
	}

	public Boolean getUseLongCodeForText() {
		return useLongCodeForText;
	}

	public void setUseLongCodeForText(Boolean useLongCodeForText) {
		this.useLongCodeForText = useLongCodeForText;
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
