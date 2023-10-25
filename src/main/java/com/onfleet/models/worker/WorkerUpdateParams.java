package com.onfleet.models.worker;

import com.onfleet.models.Metadata;

import java.util.List;

public class WorkerUpdateParams {
	private WorkerAddresses addresses;
	private Double capacity;
	private String displayName;
	private List<Metadata> metadata;
	private String name;
	private List<String> teams;
	private WorkerVehicle workerVehicle;

	private WorkerUpdateParams(Builder builder) {
		this.addresses = builder.addresses;
		this.capacity = builder.capacity;
		this.displayName = builder.displayName;
		this.metadata = builder.metadata;
		this.name = builder.name;
		this.teams = builder.teams;
		this.workerVehicle = builder.workerVehicle;
	}

	public static class Builder {
		private WorkerAddresses addresses;
		private Double capacity;
		private String displayName;
		private List<Metadata> metadata;
		private String name;
		private List<String> teams;
		private WorkerVehicle workerVehicle;

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

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setTeams(List<String> teams) {
			this.teams = teams;
			return this;
		}

		public Builder setWorkerVehicle(WorkerVehicle workerVehicle) {
			this.workerVehicle = workerVehicle;
			return this;
		}

		public WorkerUpdateParams build() {
			return new WorkerUpdateParams(this);
		}
	}
}
