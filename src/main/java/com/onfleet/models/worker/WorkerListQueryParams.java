package com.onfleet.models.worker;

import java.util.List;

public class WorkerListQueryParams {
	private final List<WorkerFilterFields> fields;
	private final List<String> teamIds;
	private final List<WorkerStates> workerStates;
	private final List<String> phoneNumbers;
	private final Boolean includePasswordDetails;

	private WorkerListQueryParams(Builder builder) {
		this.fields = builder.fields;
		this.teamIds = builder.teamIds;
		this.workerStates = builder.workerStates;
		this.phoneNumbers = builder.phoneNumbers;
		this.includePasswordDetails = builder.includePasswordDetails;
	}

	public List<WorkerFilterFields> getFields() {
		return fields;
	}

	public List<String> getTeamIds() {
		return teamIds;
	}

	public List<WorkerStates> getWorkerStates() {
		return workerStates;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public Boolean getIncludePasswordDetails() {
		return includePasswordDetails;
	}

	public static class Builder {
		private List<WorkerFilterFields> fields;
		private List<String> teamIds;
		private List<WorkerStates> workerStates;
		private List<String> phoneNumbers;
		private Boolean includePasswordDetails;

		public Builder fields(List<WorkerFilterFields> fields) {
			this.fields = fields;
			return this;
		}

		public Builder teamIds(List<String> teamIds) {
			this.teamIds = teamIds;
			return this;
		}

		public Builder workerStates(List<WorkerStates> workerStates) {
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
