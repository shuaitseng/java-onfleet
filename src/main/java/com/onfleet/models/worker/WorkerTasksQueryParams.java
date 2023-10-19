package com.onfleet.models.worker;

public class WorkerTasksQueryParams {
	private Long from;
	private Long to;
	private String lastId;
	private Boolean isPickUpTask;

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
}
