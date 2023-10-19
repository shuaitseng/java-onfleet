package com.onfleet.models.worker;

import java.util.List;

public class WorkerListQueryParams {
	private List<String> fields;
	private List<String> teamIds;
	private List<Integer> workerStates;
	private List<String> phoneNumbers;
	private Boolean includePasswordDetails;
}
