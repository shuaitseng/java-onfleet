package com.onfleet.models.task;

import java.util.List;

public class BatchJobStatus {
	private String status;
	private String submitted;
	private Integer taskReceived;
	private Integer tasksCreated;
	private Integer tasksErrored;
	private List<Task> newTasksWithWarnings;
	private List<Task> newTasks;
	private List<TaskParams> failedTasks;
	private List<TaskBatchCreateError> errors;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public Integer getTaskReceived() {
		return taskReceived;
	}

	public void setTaskReceived(Integer taskReceived) {
		this.taskReceived = taskReceived;
	}

	public Integer getTasksCreated() {
		return tasksCreated;
	}

	public void setTasksCreated(Integer tasksCreated) {
		this.tasksCreated = tasksCreated;
	}

	public Integer getTasksErrored() {
		return tasksErrored;
	}

	public void setTasksErrored(Integer tasksErrored) {
		this.tasksErrored = tasksErrored;
	}

	public List<Task> getNewTasksWithWarnings() {
		return newTasksWithWarnings;
	}

	public void setNewTasksWithWarnings(List<Task> newTasksWithWarnings) {
		this.newTasksWithWarnings = newTasksWithWarnings;
	}

	public List<Task> getNewTasks() {
		return newTasks;
	}

	public void setNewTasks(List<Task> newTasks) {
		this.newTasks = newTasks;
	}

	public List<TaskParams> getFailedTasks() {
		return failedTasks;
	}

	public void setFailedTasks(List<TaskParams> failedTasks) {
		this.failedTasks = failedTasks;
	}

	public List<TaskBatchCreateError> getErrors() {
		return errors;
	}

	public void setErrors(List<TaskBatchCreateError> errors) {
		this.errors = errors;
	}
}
