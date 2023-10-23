package com.onfleet.models.task;

import java.util.List;

public class TaskAutoAssignParam {
	private Boolean considerDependencies;
	private List<String> excludedWorkerIds;
	private Integer maxAssignedTaskCount;
	private TaskAutoAssignMode mode;
	private String team;

	private TaskAutoAssignParam(Builder builder) {
		considerDependencies = builder.considerDependencies;
		excludedWorkerIds = builder.excludedWorkerIds;
		maxAssignedTaskCount = builder.maxAssignedTaskCount;
		mode = builder.mode;
		team = builder.team;
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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
