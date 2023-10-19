package com.onfleet.models.worker;

import com.onfleet.models.task.Task;

import java.util.List;

public class WorkerTasks {
	private String lastId;
	private List<Task> tasks;

	public String getLastId() {
		return lastId;
	}

	public void setLastId(String lastId) {
		this.lastId = lastId;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
