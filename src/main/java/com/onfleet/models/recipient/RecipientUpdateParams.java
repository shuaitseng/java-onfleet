package com.onfleet.models.recipient;

import com.onfleet.models.Metadata;

import java.util.List;

public class RecipientUpdateParams {
	private String name;
	private String notes;
	private Boolean skipSmsNotifications;
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

	public Boolean getSkipSmsNotifications() {
		return skipSmsNotifications;
	}

	public void setSkipSmsNotifications(Boolean skipSmsNotifications) {
		this.skipSmsNotifications = skipSmsNotifications;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}
}
