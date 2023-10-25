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
