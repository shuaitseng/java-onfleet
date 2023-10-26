package com.onfleet.models.task;

import java.util.List;

public class TaskCompletionEvent {
	List<Double> location;
	String name;
	String time;

	public List<Double> getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}
}
