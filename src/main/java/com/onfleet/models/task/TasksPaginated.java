package com.onfleet.models.task;

import java.util.List;

public class TasksPaginated {
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
