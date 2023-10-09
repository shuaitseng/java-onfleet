package com.onfleet.models;

public class Container {
	private String id;
	private Long timeCreated;
	private Long timeLastModified;
	private String organization;
	private String type;
	private String activeTask;
	private String[] tasks;
	private String worker;

	public Container() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(Long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActiveTask() {
		return activeTask;
	}

	public void setActiveTask(String activeTask) {
		this.activeTask = activeTask;
	}

	public String[] getTasks() {
		return tasks;
	}

	public void setTasks(String[] tasks) {
		this.tasks = tasks;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}
}
