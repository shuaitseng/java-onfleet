package com.onfleet.models.task;

public class TaskState {
	public static final int UNASSIGNED = 0;
	public static final int ASSIGNED = 1;
	public static final int ACTIVE = 2;
	public static final int COMPLETED = 3;

	private TaskState() {
	}
}
