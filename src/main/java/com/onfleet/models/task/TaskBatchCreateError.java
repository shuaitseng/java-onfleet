package com.onfleet.models.task;

import com.onfleet.models.ErrorResponseMessage;

public class TaskBatchCreateError {
	private ErrorResponseMessage error;
	private TaskParams task;

	public ErrorResponseMessage getError() {
		return error;
	}

	public void setError(ErrorResponseMessage error) {
		this.error = error;
	}

	public TaskParams getTask() {
		return task;
	}

	public void setTask(TaskParams task) {
		this.task = task;
	}
}
