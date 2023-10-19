package com.onfleet.models.worker;

import java.util.List;

public class WorkerListQueryParams {
	private List<String> fields;
	private List<String> teamIds;
	private List<Integer> workerStates;
	private List<String> phoneNumbers;
	private Boolean includePasswordDetails;

	public List<String> getFields() {
		return fields;
	}

	public List<String> getTeamIds() {
		return teamIds;
	}

	public List<Integer> getWorkerStates() {
		return workerStates;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public Boolean getIncludePasswordDetails() {
		return includePasswordDetails;
	}
}
