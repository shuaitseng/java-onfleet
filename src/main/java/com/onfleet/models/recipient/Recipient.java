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
	private Long timeCreated;
	private Long timeLastModified;
	private String organization;
	private List<Metadata> metadata;

	private Recipient(Builder builder) {
		id = builder.id;
		name = builder.name;
		phone = builder.phone;
		notes = builder.notes;
		skipSMSNotifications = builder.skipSMSNotifications;
		timeCreated = builder.timeCreated;
		timeLastModified = builder.timeLastModified;
		organization = builder.organization;
		metadata = builder.metadata;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getNotes() {
		return notes;
	}

	public Boolean getSkipSMSNotifications() {
		return skipSMSNotifications;
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public long getTimeLastModified() {
		return timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public static class Builder {
		private String id;
		private String name;
		private String phone;
		private String notes;
		private Boolean skipSMSNotifications;
		private Long timeCreated;
		private Long timeLastModified;
		private String organization;
		private List<Metadata> metadata;

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder setNotes(String notes) {
			this.notes = notes;
			return this;
		}

		public Builder setSkipSMSNotifications(Boolean skipSMSNotifications) {
			this.skipSMSNotifications = skipSMSNotifications;
			return this;
		}

		public Builder setTimeCreated(long timeCreated) {
			this.timeCreated = timeCreated;
			return this;
		}

		public Builder setTimeLastModified(long timeLastModified) {
			this.timeLastModified = timeLastModified;
			return this;
		}

		public Builder setOrganization(String organization) {
			this.organization = organization;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Recipient build() {
			return new Recipient(this);
		}
	}

}
