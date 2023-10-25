package com.onfleet.models.destination;

import com.onfleet.models.Metadata;

import java.util.List;

public class Destination {
	private String id;
	private Address address;
	private String googlePlaceId;
	private List<Double> location;
	private List<Metadata> metadata;
	private String notes;
	private Long timeCreated;
	private Long timeLastModified;
	private List<String> warnings;

	private Destination(Builder builder) {
		id = builder.id;
		address = builder.address;
		googlePlaceId = builder.googlePlaceId;
		location = builder.location;
		metadata = builder.metadata;
		notes = builder.notes;
		timeCreated = builder.timeCreated;
		timeLastModified = builder.timeLastModified;
		warnings = builder.warnings;
	}

	public String getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public String getGooglePlaceId() {
		return googlePlaceId;
	}

	public List<Double> getLocation() {
		return location;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public String getNotes() {
		return notes;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public static class Builder {
		private String id;
		private Address address;
		private String googlePlaceId;
		private List<Double> location;
		private List<Metadata> metadata;
		private String notes;
		private Long timeCreated;
		private Long timeLastModified;
		private List<String> warnings;

		public Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Builder setAddress(Address address) {
			this.address = address;
			return this;
		}

		public Builder setGooglePlaceId(String googlePlaceId) {
			this.googlePlaceId = googlePlaceId;
			return this;
		}

		public Builder setLocation(List<Double> location) {
			this.location = location;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder setNotes(String notes) {
			this.notes = notes;
			return this;
		}

		public Builder setTimeCreated(Long timeCreated) {
			this.timeCreated = timeCreated;
			return this;
		}

		public Builder setTimeLastModified(Long timeLastModified) {
			this.timeLastModified = timeLastModified;
			return this;
		}

		public Builder setWarnings(List<String> warnings) {
			this.warnings = warnings;
			return this;
		}

		public Destination build() {
			return new Destination(this);
		}
	}

}
