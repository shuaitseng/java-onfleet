package com.onfleet.models.task;

import com.onfleet.models.container.ContainerType;

public class TaskContainer {
	private String organization;
	private String team;
	private ContainerType type;
	private String worker;

	private TaskContainer(Builder builder) {
		organization = builder.organization;
		team = builder.team;
		type = builder.type;
		worker = builder.worker;
	}

	public static class Builder {
		private String organization;
		private String team;
		private ContainerType type;
		private String worker;

		public Builder setOrganization(String organization) {
			this.organization = organization;
			return this;
		}

		public Builder setTeam(String team) {
			this.team = team;
			return this;
		}

		public Builder setType(ContainerType type) {
			this.type = type;
			return this;
		}

		public Builder setWorker(String worker) {
			this.worker = worker;
			return this;
		}

		public TaskContainer build() {
			return new TaskContainer(this);
		}
	}

}
