package com.onfleet.models.recipient;

import com.onfleet.models.Metadata;

import java.util.List;

public class RecipientCreateParams {
	private String name;
	private String notes;
	private String phone;
	private Boolean skipPhoneNumberValidation;
	private Boolean skipSmsNotifications;
	private Boolean useLongCodeForText;
	private List<Metadata> metadata;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getSkipPhoneNumberValidation() {
		return skipPhoneNumberValidation;
	}

	public void setSkipPhoneNumberValidation(Boolean skipPhoneNumberValidation) {
		this.skipPhoneNumberValidation = skipPhoneNumberValidation;
	}

	public Boolean getSkipSmsNotifications() {
		return skipSmsNotifications;
	}

	public void setSkipSmsNotifications(Boolean skipSmsNotifications) {
		this.skipSmsNotifications = skipSmsNotifications;
	}

	public Boolean getUseLongCodeForText() {
		return useLongCodeForText;
	}

	public void setUseLongCodeForText(Boolean useLongCodeForText) {
		this.useLongCodeForText = useLongCodeForText;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
}
