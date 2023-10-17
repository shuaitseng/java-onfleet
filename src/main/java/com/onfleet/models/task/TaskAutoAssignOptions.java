package com.onfleet.models.task;

import java.util.List;

public class TaskAutoAssignOptions {
	private Boolean considerDependencies;
	private List<String> excludedWorkerIds;
	private Integer maxAssignedTaskCount;
	private TaskAutoAssignMode mode;
	private Boolean restrictAutoAssignmentToTeam;
	private List<String> teams;

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
}
