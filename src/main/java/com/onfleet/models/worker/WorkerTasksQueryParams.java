package com.onfleet.models.worker;

public class WorkerTasksQueryParams {
	private Long from;
	private Long to;
	private String lastId;
	private Boolean isPickUpTask;

	private WorkerTasksQueryParams(Builder builder) {
		this.from = builder.from;
		this.to = builder.to;
		this.lastId = builder.lastId;
		this.isPickUpTask = builder.isPickUpTask;
	}

	public Long getFrom() {
		return from;
	}

	public Long getTo() {
		return to;
	}

	public String getLastId() {
		return lastId;
	}

	public Boolean getPickUpTask() {
		return isPickUpTask;
	}

	public static class Builder {
		private Long from;
		private Long to;
		private String lastId;
		private Boolean isPickUpTask;

		public Builder from(Long from) {
			this.from = from;
			return this;
		}

		public Builder to(Long to) {
			this.to = to;
			return this;
		}

		public Builder lastId(String lastId) {
			this.lastId = lastId;
			return this;
		}

		public Builder isPickUpTask(Boolean isPickUpTask) {
			this.isPickUpTask = isPickUpTask;
			return this;
		}

		public WorkerTasksQueryParams build() {
			return new WorkerTasksQueryParams(this);
		}
	}
}
