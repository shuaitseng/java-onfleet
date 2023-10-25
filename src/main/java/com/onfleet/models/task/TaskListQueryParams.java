package com.onfleet.models.task;

import java.util.List;

public class TaskListQueryParams {
	private long from;
	private Long to;
	private String lastId;
	private String worker;
	private Long completeBeforeBefore;
	private Long completeAfterAfter;
	private List<TaskState> states;
	private List<String> taskDependencies;

	public TaskListQueryParams(long from) {
		this.from = from;
	}

	private TaskListQueryParams(Builder builder) {
		from = builder.from;
		to = builder.to;
		lastId = builder.lastId;
		worker = builder.worker;
		completeBeforeBefore = builder.completeBeforeBefore;
		completeAfterAfter = builder.completeAfterAfter;
		states = builder.states;
		taskDependencies = builder.taskDependencies;
	}

	public long getFrom() {
		return from;
	}

	public Long getTo() {
		return to;
	}

	public String getLastId() {
		return lastId;
	}

	public String getWorker() {
		return worker;
	}

	public Long getCompleteBeforeBefore() {
		return completeBeforeBefore;
	}

	public Long getCompleteAfterAfter() {
		return completeAfterAfter;
	}

	public List<TaskState> getStates() {
		return states;
	}

	public List<String> getTaskDependencies() {
		return taskDependencies;
	}

	public static class Builder {
		private final long from;
		private Long to;
		private String lastId;
		private String worker;
		private Long completeBeforeBefore;
		private Long completeAfterAfter;
		private List<TaskState> states;
		private List<String> taskDependencies;

		public Builder(long from) {
			this.from = from;
		}

		public Builder setTo(Long to) {
			this.to = to;
			return this;
		}

		public Builder setLastId(String lastId) {
			this.lastId = lastId;
			return this;
		}

		public Builder setWorker(String worker) {
			this.worker = worker;
			return this;
		}

		public Builder setCompleteBeforeBefore(Long completeBeforeBefore) {
			this.completeBeforeBefore = completeBeforeBefore;
			return this;
		}

		public Builder setCompleteAfterAfter(Long completeAfterAfter) {
			this.completeAfterAfter = completeAfterAfter;
			return this;
		}

		public Builder setStates(List<TaskState> states) {
			this.states = states;
			return this;
		}

		public Builder setTaskDependencies(List<String> taskDependencies) {
			this.taskDependencies = taskDependencies;
			return this;
		}

		public TaskListQueryParams build() {
			return new TaskListQueryParams(this);
		}
	}

}
