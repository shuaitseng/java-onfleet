package com.onfleet.models.worker;

import java.util.List;

public class WorkerQueryParams {
	private List<WorkerFilterFields> filterFields;
	private List<String> phones;
	private List<Integer> states;
	private List<String> teams;
	private Boolean enableAnalytics;

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

		public Builder filterFields(List<WorkerFilterFields> filterFields) {
			this.filterFields = filterFields;
			return this;
		}

		public Builder phones(List<String> phones) {
			this.phones = phones;
			return this;
		}

		public Builder states(List<Integer> states) {
			this.states = states;
			return this;
		}

		public Builder teams(List<String> teams) {
			this.teams = teams;
			return this;
		}

		public Builder enableAnalytics(Boolean enableAnalytics) {
			this.enableAnalytics = enableAnalytics;
			return this;
		}

		public WorkerQueryParams build() {
			return new WorkerQueryParams(this);
		}
	}

}
