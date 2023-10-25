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

	public String getSubmitted() {
		return submitted;
	}

	public Integer getTaskReceived() {
		return taskReceived;
	}

	public Integer getTasksCreated() {
		return tasksCreated;
	}

	public Integer getTasksErrored() {
		return tasksErrored;
	}

	public List<Task> getNewTasksWithWarnings() {
		return newTasksWithWarnings;
	}

	public List<Task> getNewTasks() {
		return newTasks;
	}

	public List<TaskParams> getFailedTasks() {
		return failedTasks;
	}

	public List<TaskBatchCreateError> getErrors() {
		return errors;
	}

}
