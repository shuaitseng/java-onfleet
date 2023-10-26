package com.onfleet.models.task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tasks {
	@SerializedName("tasks")
	private List<Task> tasksList;
	public List<Task> getTasks() {
		return tasksList;
	}
}
