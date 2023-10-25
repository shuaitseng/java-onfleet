package com.onfleet.models.task;

import java.util.List;

public class TasksPaginated {
	private String lastId;
	private List<Task> tasks;

	public String getLastId() {
		return lastId;
	}

	public List<Task> getTasks() {
		return tasks;
	}
}
