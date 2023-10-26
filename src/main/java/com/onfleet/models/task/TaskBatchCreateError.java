package com.onfleet.models.task;


public class TaskBatchCreateError {
	private Integer statusCode;
	private Integer errorCode;
	private String message;
	private String cause;
	private Task taskData;

	public Integer getStatusCode() {
		return statusCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public String getCause() {
		return cause;
	}

	public Task getTaskData() {
		return taskData;
	}
}
