package com.onfleet.models.task;

import java.util.List;

public class TaskAutoAssignOptions {
	private Boolean considerDependencies;
	private List<String> excludedWorkerIds;
	private Integer maxAssignedTaskCount;
	private TaskAutoAssignMode mode;
	private Boolean restrictAutoAssignmentToTeam;
	private List<String> teams;

	private TaskAutoAssignOptions(Builder builder) {
		considerDependencies = builder.considerDependencies;
		excludedWorkerIds = builder.excludedWorkerIds;
		maxAssignedTaskCount = builder.maxAssignedTaskCount;
		mode = builder.mode;
		restrictAutoAssignmentToTeam = builder.restrictAutoAssignmentToTeam;
		teams = builder.teams;
	}

	public Boolean getConsiderDependencies() {
		return considerDependencies;
	}

	public void setConsiderDependencies(Boolean considerDependencies) {
		this.considerDependencies = considerDependencies;
	}

	public List<String> getExcludedWorkerIds() {
		return excludedWorkerIds;
	}

	public void setExcludedWorkerIds(List<String> excludedWorkerIds) {
		this.excludedWorkerIds = excludedWorkerIds;
	}

	public Integer getMaxAssignedTaskCount() {
		return maxAssignedTaskCount;
	}

	public void setMaxAssignedTaskCount(Integer maxAssignedTaskCount) {
		this.maxAssignedTaskCount = maxAssignedTaskCount;
	}

	public TaskAutoAssignMode getMode() {
		return mode;
	}

	public void setMode(TaskAutoAssignMode mode) {
		this.mode = mode;
	}

	public Boolean getRestrictAutoAssignmentToTeam() {
		return restrictAutoAssignmentToTeam;
	}

	public void setRestrictAutoAssignmentToTeam(Boolean restrictAutoAssignmentToTeam) {
		this.restrictAutoAssignmentToTeam = restrictAutoAssignmentToTeam;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

	public static class Builder {
		private Boolean considerDependencies;
		private List<String> excludedWorkerIds;
		private Integer maxAssignedTaskCount;
		private TaskAutoAssignMode mode;
		private Boolean restrictAutoAssignmentToTeam;
		private List<String> teams;

		public Builder setConsiderDependencies(Boolean considerDependencies) {
			this.considerDependencies = considerDependencies;
			return this;
		}

		public Builder setExcludedWorkerIds(List<String> excludedWorkerIds) {
			this.excludedWorkerIds = excludedWorkerIds;
			return this;
		}

		public Builder setMaxAssignedTaskCount(Integer maxAssignedTaskCount) {
			this.maxAssignedTaskCount = maxAssignedTaskCount;
			return this;
		}

		public Builder setMode(TaskAutoAssignMode mode) {
			this.mode = mode;
			return this;
		}

		public Builder setRestrictAutoAssignmentToTeam(Boolean restrictAutoAssignmentToTeam) {
			this.restrictAutoAssignmentToTeam = restrictAutoAssignmentToTeam;
			return this;
		}

		public Builder setTeams(List<String> teams) {
			this.teams = teams;
			return this;
		}

		public TaskAutoAssignOptions build() {
			return new TaskAutoAssignOptions(this);
		}
	}

}
