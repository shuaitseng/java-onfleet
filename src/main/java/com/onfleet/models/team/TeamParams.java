package com.onfleet.models.team;

import java.util.List;

public class TeamParams {
	private Boolean enableSelfAssignment;
	private String hub;
	private List<String> managers;
	private String name;
	private List<String> workers;

	public Boolean getEnableSelfAssignment() {
		return enableSelfAssignment;
	}

	public void setEnableSelfAssignment(Boolean enableSelfAssignment) {
		this.enableSelfAssignment = enableSelfAssignment;
	}

	public String getHub() {
		return hub;
	}

	public void setHub(String hub) {
		this.hub = hub;
	}

	public List<String> getManagers() {
		return managers;
	}

	public void setManagers(List<String> managers) {
		this.managers = managers;
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
}
