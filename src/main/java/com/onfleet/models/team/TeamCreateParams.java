package com.onfleet.models.team;

import java.util.List;

public class TeamCreateParams {
	private Boolean enableSelfAssignment;
	private String hub;
	private List<String> managers;
	private String name;
	private List<String> workers;

	private TeamCreateParams(Builder builder) {
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
		private final List<String> managers;
		private final String name;
		private final List<String> workers;

		public Builder(String name, List<String> managers, List<String> workers) {
			this.name = name;
			this.managers = managers;
			this.workers = workers;
		}

		public Builder setEnableSelfAssignment(Boolean enableSelfAssignment) {
			this.enableSelfAssignment = enableSelfAssignment;
			return this;
		}

		public Builder setHub(String hub) {
			this.hub = hub;
			return this;
		}

		public TeamCreateParams build() {
			return new TeamCreateParams(this);
		}
	}
}
