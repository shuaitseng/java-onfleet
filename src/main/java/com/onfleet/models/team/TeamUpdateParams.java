package com.onfleet.models.team;

import java.util.ArrayList;
import java.util.List;

public class TeamUpdateParams {

	private Boolean enableSelfAssignment;
	private String hub;
	private List<String> managers;
	private String name;
	private List<String> workers;

	private TeamUpdateParams(Builder builder) {
		this.enableSelfAssignment = builder.enableSelfAssignment;
		this.hub = builder.hub;
		this.managers = builder.managers;
		this.name = builder.name;
		this.workers = builder.workers;
	}

	public Boolean getEnableSelfAssignment() {
		return enableSelfAssignment;
	}

	public void setEnableSelfAssignment(Boolean enableSelfAssignment) {
		this.enableSelfAssignment = enableSelfAssignment;
	}

	public String getHub() {
		return hub;
	}

	public void setHub(String hub) {
		this.hub = hub;
	}

	public List<String> getManagers() {
		return managers;
	}

	public void setManagers(List<String> managers) {
		this.managers = managers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getWorkers() {
		return workers;
	}

	public void setWorkers(List<String> workers) {
		this.workers = workers;
	}

	public static class Builder {
		private Boolean enableSelfAssignment;
		private String hub;
		private List<String> managers = new ArrayList<>();
		private List<String> workers = new ArrayList<>();
		private String name;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder enableSelfAssignment(Boolean enableSelfAssignment) {
			this.enableSelfAssignment = enableSelfAssignment;
			return this;
		}

		public Builder hub(String hub) {
			this.hub = hub;
			return this;
		}

		public Builder setManagers(List<String> managers) {
			this.managers = managers;
			return this;
		}

		public Builder addManager(String manager) {
			this.managers.add(manager);
			return this;
		}

		public Builder setWorkers(List<String> workers) {
			this.workers = workers;
			return this;
		}

		public Builder addWorker(String worker) {
			this.workers.add(worker);
			return this;
		}

		public TeamUpdateParams build() {
			return new TeamUpdateParams(this);
		}
	}

}
