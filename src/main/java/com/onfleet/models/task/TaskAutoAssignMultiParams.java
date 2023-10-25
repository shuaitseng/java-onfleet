package com.onfleet.models.task;

import java.util.List;

public class TaskAutoAssignMultiParams {
	private List<String> tasks;
	private TaskAutoAssignOptions options;

	private TaskAutoAssignMultiParams(Builder builder) {
		tasks = builder.tasks;
		options = builder.options;
	}

	public static class Builder {
		private List<String> tasks;
		private TaskAutoAssignOptions options;

		public Builder setTasks(List<String> tasks) {
			this.tasks = tasks;
			return this;
		}

		public Builder setOptions(TaskAutoAssignOptions options) {
			this.options = options;
			return this;
		}

		public TaskAutoAssignMultiParams build() {
			return new TaskAutoAssignMultiParams(this);
		}
	}

}
