package com.onfleet.models.task;

import java.util.List;

public class TaskBatchCreateResponse {
	private List<Task> tasks;
	private List<TaskBatchCreateError> errors;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<TaskBatchCreateError> getErrors() {
		return errors;
	}

	public void setErrors(List<TaskBatchCreateError> errors) {
		this.errors = errors;
	}
}
