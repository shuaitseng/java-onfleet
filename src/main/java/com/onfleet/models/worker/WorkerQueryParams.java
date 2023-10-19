package com.onfleet.models.worker;

import java.util.List;

public class WorkerQueryParams {
	private List<WorkerFilterFields> filterFields;
	private List<String> phones;
	private List<Integer> states;
	private List<String> teams;
	private Boolean enableAnalytics;

	public List<WorkerFilterFields> getFilterFields() {
		return filterFields;
	}

	public List<String> getPhones() {
		return phones;
	}

	public List<Integer> getStates() {
		return states;
	}

	public List<String> getTeams() {
		return teams;
	}

	public Boolean getEnableAnalytics() {
		return enableAnalytics;
	}
}
