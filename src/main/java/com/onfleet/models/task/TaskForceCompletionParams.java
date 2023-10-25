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

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
