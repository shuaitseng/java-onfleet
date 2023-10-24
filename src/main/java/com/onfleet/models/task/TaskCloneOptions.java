package com.onfleet.models.task;

public class TaskCloneOptions {
	private TaskCloneParams options;

	public TaskCloneOptions(TaskCloneParams options) {
		this.options = options;
	}

	public TaskCloneParams getOptions() {
		return options;
	}

	public void setOptions(TaskCloneParams options) {
		this.options = options;
	}
}
