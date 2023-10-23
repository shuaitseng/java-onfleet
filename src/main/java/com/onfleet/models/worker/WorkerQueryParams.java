package com.onfleet.models.worker;

import java.util.List;

public class WorkerQueryParams {
	private final List<WorkerFilterFields> filterFields;
	private final List<String> phones;
	private final List<Integer> states;
	private final List<String> teams;
	private final Boolean enableAnalytics;

	private WorkerQueryParams(Builder builder) {
		this.filterFields = builder.filterFields;
		this.phones = builder.phones;
		this.states = builder.states;
		this.teams = builder.teams;
		this.enableAnalytics = builder.enableAnalytics;
	}

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

	public static class Builder {
		private List<WorkerFilterFields> filterFields;
		private List<String> phones;
		private List<Integer> states;
		private List<String> teams;
		private Boolean enableAnalytics;

		public Builder setFilterFields(List<WorkerFilterFields> filterFields) {
			this.filterFields = filterFields;
			return this;
		}

		public Builder setPhones(List<String> phones) {
			this.phones = phones;
			return this;
		}

		public Builder setStates(List<Integer> states) {
			this.states = states;
			return this;
		}

		public Builder setTeams(List<String> teams) {
			this.teams = teams;
			return this;
		}

		public Builder setEnableAnalytics(Boolean enableAnalytics) {
			this.enableAnalytics = enableAnalytics;
			return this;
		}

		public WorkerQueryParams build() {
			return new WorkerQueryParams(this);
		}
	}

}
