package com.onfleet.models.worker;

import com.onfleet.models.Metadata;

import java.util.List;

public class WorkerCreateParams {
	private WorkerAddresses addresses;
	private Double capacity;
	private String displayName;
	private List<Metadata> metadata;
	private String name;
	private String phone;
	private List<String> teams;
	private WorkerVehicle workerVehicle;

	private WorkerCreateParams(Builder builder) {
		this.addresses = builder.addresses;
		this.capacity = builder.capacity;
		this.displayName = builder.displayName;
		this.metadata = builder.metadata;
		this.name = builder.name;
		this.phone = builder.phone;
		this.teams = builder.teams;
		this.workerVehicle = builder.workerVehicle;
	}

	public static class Builder {
		private final String name;
		private final String phone;
		private final List<String> teams;
		private WorkerAddresses addresses;
		private Double capacity;
		private String displayName;
		private List<Metadata> metadata;
		private WorkerVehicle workerVehicle;

		public Builder(String name, String phone, List<String> teams) {
			this.name = name;
			this.phone = phone;
			this.teams = teams;
		}

		public Builder setAddresses(WorkerAddresses addresses) {
			this.addresses = addresses;
			return this;
		}

		public Builder setCapacity(Double capacity) {
			this.capacity = capacity;
			return this;
		}

		public Builder setDisplayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder setWorkerVehicle(WorkerVehicle workerVehicle) {
			this.workerVehicle = workerVehicle;
			return this;
		}

		public WorkerCreateParams build() {
			return new WorkerCreateParams(this);
		}
	}
}
