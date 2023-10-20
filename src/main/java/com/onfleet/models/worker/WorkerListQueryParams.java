package com.onfleet.models.worker;

import java.util.List;

public class WorkerListQueryParams {
	private List<String> fields;
	private List<String> teamIds;
	private List<Integer> workerStates;
	private List<String> phoneNumbers;
	private Boolean includePasswordDetails;

	private WorkerListQueryParams(Builder builder) {
		this.fields = builder.fields;
		this.teamIds = builder.teamIds;
		this.workerStates = builder.workerStates;
		this.phoneNumbers = builder.phoneNumbers;
		this.includePasswordDetails = builder.includePasswordDetails;
	}

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

	public static class Builder {
		private List<String> fields;
		private List<String> teamIds;
		private List<Integer> workerStates;
		private List<String> phoneNumbers;
		private Boolean includePasswordDetails;

		public Builder fields(List<String> fields) {
			this.fields = fields;
			return this;
		}

		public Builder teamIds(List<String> teamIds) {
			this.teamIds = teamIds;
			return this;
		}

		public Builder workerStates(List<Integer> workerStates) {
			this.workerStates = workerStates;
			return this;
		}

		public Builder phoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
			return this;
		}

		public Builder includePasswordDetails(Boolean includePasswordDetails) {
			this.includePasswordDetails = includePasswordDetails;
			return this;
		}

		public WorkerListQueryParams build() {
			return new WorkerListQueryParams(this);
		}
	}
}
