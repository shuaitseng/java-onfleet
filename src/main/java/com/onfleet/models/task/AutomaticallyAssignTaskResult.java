package com.onfleet.models.task;

import java.util.Map;

public class AutomaticallyAssignTaskResult {
	private Integer assignedTasksCount;
	private TaskMap assignedTasks;

	public Integer getAssignedTasksCount() {
		return assignedTasksCount;
	}

	public TaskMap getAssignedTasks() {
		return assignedTasks;
	}

	public static class TaskMap {
		private Map<String, String> taskMap;

		public Map<String, String> getTaskMap() {
			return taskMap;
		}
	}

}
