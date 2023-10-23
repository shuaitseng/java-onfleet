package com.onfleet.models.task;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tasks {
	@JsonProperty("tasks")
	private List<Task> tasksList;
	public List<Task> getTasks() {
		return tasksList;
	}
	public void setTasks(List<Task> tasksList) {
		this.tasksList = tasksList;
	}
}
