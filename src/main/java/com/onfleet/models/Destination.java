package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination {
	@JsonProperty("address")
	private Address address;
	@JsonProperty("location")
	private Double[] location;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("options")
	private Options options;

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
