package com.onfleet.models.task;

public class TaskForceCompletionParams {
	private Boolean success;
	private String notes;

	public TaskForceCompletionParams(Boolean success, String notes) {
		this.success = success;
		this.notes = notes;
	}

	public TaskForceCompletionParams(Boolean success) {
		this.success = success;
	}
}
