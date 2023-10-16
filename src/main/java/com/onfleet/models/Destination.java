package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Destination {
	private String id;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("location")
	private Double[] location;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("options")
	private Options options;
	private String[] warnings;
	private Long timeCreated;
	private Long timeLastModified;
	private List<Metadata> metadata;
	private Boolean useGPS;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Double[] getLocation() {
		return location;
	}

	public void setLocation(Double[] location) {
		this.location = location;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public String[] getWarnings() {
		return warnings;
	}

	public void setWarnings(String[] warnings) {
		this.warnings = warnings;
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

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public Boolean getUseGPS() {
		return useGPS;
	}

	public void setUseGPS(Boolean useGPS) {
		this.useGPS = useGPS;
	}

	public static class Builder {
		private final Destination destination = new Destination();

		public Builder setAddress(Address address) {
			destination.setAddress(address);
			return this;
		}

		public Builder setLocation(Double[] location) {
			destination.setLocation(location);
			return this;
		}

		public Builder setNotes(String notes) {
			destination.setNotes(notes);
			return this;
		}

		public Builder setOptions(Options options) {
			destination.setOptions(options);
			return this;
		}

		public Destination build() {
			return destination;
		}
	}

}
