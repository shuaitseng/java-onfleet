package com.onfleet.models.task;

import java.util.List;

public class TaskAutoAssignParam {
	private final Boolean considerDependencies;
	private final List<String> excludedWorkerIds;
	private final Integer maxAssignedTaskCount;
	private final TaskAutoAssignMode mode;
	private final String team;

	private TaskAutoAssignParam(Builder builder) {
		considerDependencies = builder.considerDependencies;
		excludedWorkerIds = builder.excludedWorkerIds;
		maxAssignedTaskCount = builder.maxAssignedTaskCount;
		mode = builder.mode;
		team = builder.team;
	}

	public static class Builder {
		private Boolean considerDependencies;
		private List<String> excludedWorkerIds;
		private Integer maxAssignedTaskCount;
		private TaskAutoAssignMode mode;
		private String team;

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

		public Builder setTeam(String team) {
			this.team = team;
			return this;
		}

		public TaskAutoAssignParam build() {
			return new TaskAutoAssignParam(this);
		}
	}

}
