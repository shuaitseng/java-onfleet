package com.onfleet.models.destination;

import com.onfleet.models.Address;
import com.onfleet.models.Metadata;

import java.util.List;

public class DestinationCreateParams {
	private final Address address;
	private final List<Double> location;
	private final List<com.onfleet.models.Metadata> metadata;
	private final String notes;
	private final DestinationOptions options;

	private DestinationCreateParams(Builder builder) {
		this.address = builder.address;
		this.location = builder.location;
		this.metadata = builder.metadata;
		this.notes = builder.notes;
		this.options = builder.options;
	}

	public Address getAddress() {
		return address;
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

	public DestinationOptions getOptions() {
		return options;
	}

	public static class Builder {
		private final Address address;
		private List<Double> location;
		private List<Metadata> metadata;
		private String notes;
		private DestinationOptions options;

		public Builder(Address address) {
			this.address = address;
		}

		public Builder location(List<Double> location) {
			this.location = location;
			return this;
		}

		public Builder metadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder notes(String notes) {
			this.notes = notes;
			return this;
		}

		public Builder options(DestinationOptions options) {
			this.options = options;
			return this;
		}

		public DestinationCreateParams build() {
			return new DestinationCreateParams(this);
		}
	}

}