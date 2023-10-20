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

	public WorkerAddresses getAddresses() {
		return addresses;
	}

	private WorkerUpdateParams(Builder builder) {
		this.addresses = builder.addresses;
		this.capacity = builder.capacity;
		this.displayName = builder.displayName;
		this.metadata = builder.metadata;
		this.name = builder.name;
		this.teams = builder.teams;
		this.workerVehicle = builder.workerVehicle;
	}

	public void setAddresses(WorkerAddresses addresses) {
		this.addresses = addresses;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

	public WorkerVehicle getWorkerVehicle() {
		return workerVehicle;
	}

	public void setWorkerVehicle(WorkerVehicle workerVehicle) {
		this.workerVehicle = workerVehicle;
	}

	public static class Builder {
		private WorkerAddresses addresses;
		private Double capacity;
		private String displayName;
		private List<Metadata> metadata;
		private String name;
		private List<String> teams;
		private WorkerVehicle workerVehicle;

		public Builder(String name, List<String> teams) {
			this.name = name;
			this.teams = teams;
		}

		public Builder addresses(WorkerAddresses addresses) {
			this.addresses = addresses;
			return this;
		}

		public Builder capacity(Double capacity) {
			this.capacity = capacity;
			return this;
		}

		public Builder displayName(String displayName) {
			this.displayName = displayName;
			return this;
		}

		public Builder metadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder workerVehicle(WorkerVehicle workerVehicle) {
			this.workerVehicle = workerVehicle;
			return this;
		}

		public WorkerUpdateParams build() {
			return new WorkerUpdateParams(this);
		}
	}
}
