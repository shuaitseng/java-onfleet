package com.onfleet.models.worker;

import com.onfleet.models.WorkerFilterFields;

import java.util.List;

public class WorkerQueryParams {
	private List<WorkerFilterFields> filterFields;
	private List<String> phones;
	private List<Integer> states;
	private List<String> teams;
	private Boolean enableAnalytics;
}
