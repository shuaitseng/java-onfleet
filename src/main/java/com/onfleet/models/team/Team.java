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

	public String getName() {
		return name;
	}

	public List<String> getWorkers() {
		return workers;
	}

	public List<String> getManagers() {
		return managers;
	}

	public String getHubId() {
		return hubId;
	}

	public Boolean getEnableSelfAssignment() {
		return enableSelfAssignment;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}
}
