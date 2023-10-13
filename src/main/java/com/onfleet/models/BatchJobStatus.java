package com.onfleet.models;

import java.util.List;

public class BatchJobStatus {
	private String status;
	private String jobId;
	private String submitted;
	private int tasksReceived;
	private int tasksCreated;
	private int tasksErrored;
	private List<Error> errors;
	private List<Task> failedTasks;
	private List<Task> newTasks;
	private List<Task> newTasksWithWarnings;

}
