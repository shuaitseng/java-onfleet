package com.onfleet.models.team;

public class TeamTasksQueryParams {
	private Boolean isPickupTask;
	private Long from;
	private Long to;
	private String lastId;

	private TeamTasksQueryParams(Builder builder) {
		isPickupTask = builder.isPickupTask;
		from = builder.from;
		to = builder.to;
		lastId = builder.lastId;
	}

	public Boolean getIsPickupTask() {
		return isPickupTask;
	}

	public Long getFrom() {
		return from;
	}

	public Long getTo() {
		return to;
	}

	public String getLastId() {
		return lastId;
	}

	public static class Builder {
		private Boolean isPickupTask;
		private Long from;
		private Long to;
		private String lastId;

		public Builder setIsPickupTask(Boolean isPickupTask) {
			this.isPickupTask = isPickupTask;
			return this;
		}

		public Builder setFrom(Long from) {
			this.from = from;
			return this;
		}

		public Builder setTo(Long to) {
			this.to = to;
			return this;
		}

		public Builder setLastId(String lastId) {
			this.lastId = lastId;
			return this;
		}

		public TeamTasksQueryParams build() {
			return new TeamTasksQueryParams(this);
		}
	}
}
