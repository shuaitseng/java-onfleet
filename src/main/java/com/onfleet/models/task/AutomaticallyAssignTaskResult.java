package com.onfleet.models.task;

import java.util.Map;

public class AutomaticallyAssignTaskResult {
	private Integer assignedTasksCount;
	private TaskMap assignedTasks;

	public Integer getAssignedTasksCount() {
		return assignedTasksCount;
	}

	public void setAssignedTasksCount(Integer assignedTasksCount) {
		this.assignedTasksCount = assignedTasksCount;
	}

	public TaskMap getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(TaskMap assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	public static class TaskMap {
		private Map<String, String> taskMap;

		public Map<String, String> getTaskMap() {
			return taskMap;
		}

		public void setTaskMap(Map<String, String> taskMap) {
			this.taskMap = taskMap;
		}
	}

}
