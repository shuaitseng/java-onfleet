package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
	private String id;
	private String name;
	private String[] workers;
	private String[] managers;
	@JsonProperty("hub")
	private String hubId;
	private Boolean enableSelfAssignment;

	public Team() {
	}

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

	public String[] getWorkers() {
		return workers;
	}

	public void setWorkers(String[] workers) {
		this.workers = workers;
	}

	public String[] getManagers() {
		return managers;
	}

	public void setManagers(String[] managers) {
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
}
