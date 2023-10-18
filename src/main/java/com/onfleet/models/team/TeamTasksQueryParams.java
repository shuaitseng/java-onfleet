package com.onfleet.models.team;

public class TeamTasksQueryParams {
	private Boolean isPickupTask;
	private Long from;
	private Long to;
	private String lastId;

	public Boolean getIsPickupTask() {
		return isPickupTask;
	}

	public void setIsPickupTask(Boolean pickupTask) {
		isPickupTask = pickupTask;
	}

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getLastId() {
		return lastId;
	}

	public void setLastId(String lastId) {
		this.lastId = lastId;
	}

	public static class Builder {
		private Boolean isPickupTask;
		private Long from;
		private Long to;
		private String lastId;

		public Builder isPickupTask(Boolean isPickupTask) {
			this.isPickupTask = isPickupTask;
			return this;
		}

		public Builder from(Long from) {
			this.from = from;
			return this;
		}

		public Builder to(Long to) {
			this.to = to;
			return this;
		}

		public Builder lastId(String lastId) {
			this.lastId = lastId;
			return this;
		}

		public TeamTasksQueryParams build() {
			TeamTasksQueryParams queryParams = new TeamTasksQueryParams();
			queryParams.setIsPickupTask(this.isPickupTask);
			queryParams.setFrom(this.from);
			queryParams.setTo(this.to);
			queryParams.setLastId(this.lastId);
			return queryParams;
		}
	}
}
