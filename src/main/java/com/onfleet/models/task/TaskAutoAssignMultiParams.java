package com.onfleet.models.task;

import java.util.List;

public class TaskAutoAssignMultiParams {
	private List<String> tasks;
	private TaskAutoAssignOptions options;

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}

	public TaskAutoAssignOptions getOptions() {
		return options;
	}

	public void setOptions(TaskAutoAssignOptions options) {
		this.options = options;
	}
}
