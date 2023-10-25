package com.onfleet.models.container;

import java.util.List;

public class Container {
	private String id;
	private Long timeCreated;
	private Long timeLastModified;
	private String organization;
	private ContainerType type;
	private String activeTask;
	private List<String> tasks;
	private String worker;
	private String team;

	public String getId() {
		return id;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public ContainerType getType() {
		return type;
	}

	public String getActiveTask() {
		return activeTask;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public String getWorker() {
		return worker;
	}

	public String getTeam() {
		return team;
	}
}
