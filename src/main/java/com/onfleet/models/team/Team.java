package com.onfleet.models.team;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Team {
	private String id;
	private String name;
	private List<String> workers;
	private List<String> managers;
	@JsonProperty("hub")
	private String hubId;
	private Boolean enableSelfAssignment;
	private List<String> tasks;
	private Long timeCreated;
	private Long timeLastModified;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getWorkers() {
		return workers;
	}

	public void setWorkers(List<String> workers) {
		this.workers = workers;
	}

	public List<String> getManagers() {
		return managers;
	}

	public void setManagers(List<String> managers) {
		this.managers = managers;
	}

	public String getHubId() {
		return hubId;
	}

	public void setHubId(String hubId) {
		this.hubId = hubId;
	}

	public Boolean getEnableSelfAssignment() {
		return enableSelfAssignment;
	}

	public void setEnableSelfAssignment(Boolean enableSelfAssignment) {
		this.enableSelfAssignment = enableSelfAssignment;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
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
}
