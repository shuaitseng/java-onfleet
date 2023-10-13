package com.onfleet.models;

import java.util.List;

public class Worker {
	private String id;
	private String name;
	private String phone;
	private String[] teams;
	private Vehicle vehicle;
	private int capacity;
	private String displayName;
	private Long timeCreated;
	private Long timeLastModified;
	private String organization;
	private String activeTask;
	private List<String> tasks;
	private Boolean onDuty;
	private Long timeLastSeen;
	private Long delayTime; // Use Long to handle nullable values
	private List<Object> metadata; // TODO: Define metadata object
	private List<Double> location;
	private Analytics analytics;

	/*address.routing	object	Optional. This value is used to set the worker's address.*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getTeams() {
		return teams;
	}

	public void setTeams(String[] teams) {
		this.teams = teams;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(Long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getActiveTask() {
		return activeTask;
	}

	public void setActiveTask(String activeTask) {
		this.activeTask = activeTask;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}

	public Boolean getOnDuty() {
		return onDuty;
	}

	public void setOnDuty(Boolean onDuty) {
		this.onDuty = onDuty;
	}

	public Long getTimeLastSeen() {
		return timeLastSeen;
	}

	public void setTimeLastSeen(Long timeLastSeen) {
		this.timeLastSeen = timeLastSeen;
	}

	public Long getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(Long delayTime) {
		this.delayTime = delayTime;
	}

	public List<Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Object> metadata) {
		this.metadata = metadata;
	}

	public List<Double> getLocation() {
		return location;
	}

	public void setLocation(List<Double> location) {
		this.location = location;
	}

	public Analytics getAnalytics() {
		return analytics;
	}

	public void setAnalytics(Analytics analytics) {
		this.analytics = analytics;
	}

	public static class Builder {
		private final Worker worker = new Worker();

		public Builder setId(String id) {
			worker.setId(id);
			return this;
		}

		public Builder setName(String name) {
			worker.setName(name);
			return this;
		}

		public Builder setPhone(String phone) {
			worker.setPhone(phone);
			return this;
		}

		public Builder setTeams(String[] teams) {
			worker.setTeams(teams);
			return this;
		}

		public Builder setVehicle(Vehicle vehicle) {
			worker.setVehicle(vehicle);
			return this;
		}

		public Builder setCapacity(int capacity) {
			worker.setCapacity(capacity);
			return this;
		}

		public Builder setdisplayName(String displayName) {
			worker.setDisplayName(displayName);
			return this;
		}

		public Worker build() {
			return worker;
		}
	}

	public static class Analytics {
		private List<AnalyticsEvent> events;
		private Distance distances;
		private Time times;
		private TaskCounts taskCounts;

		public List<AnalyticsEvent> getEvents() {
			return events;
		}

		public void setEvents(List<AnalyticsEvent> events) {
			this.events = events;
		}

		public Distance getDistances() {
			return distances;
		}

		public void setDistances(Distance distances) {
			this.distances = distances;
		}

		public Time getTimes() {
			return times;
		}

		public void setTimes(Time times) {
			this.times = times;
		}

		public TaskCounts getTaskCounts() {
			return taskCounts;
		}

		public void setTaskCounts(TaskCounts taskCounts) {
			this.taskCounts = taskCounts;
		}

		public static class AnalyticsEvent {
			private String action;
			private Long time;

			public String getAction() {
				return action;
			}

			public void setAction(String action) {
				this.action = action;
			}

			public Long getTime() {
				return time;
			}

			public void setTime(Long time) {
				this.time = time;
			}
		}

		public static class Distance {
			private double enroute;
			private double idle;

			public double getEnroute() {
				return enroute;
			}

			public void setEnroute(double enroute) {
				this.enroute = enroute;
			}

			public double getIdle() {
				return idle;
			}

			public void setIdle(double idle) {
				this.idle = idle;
			}
		}

		public static class Time {
			private Double enroute;
			private Double idle;

			public Double getEnroute() {
				return enroute;
			}

			public void setEnroute(Double enroute) {
				this.enroute = enroute;
			}

			public Double getIdle() {
				return idle;
			}

			public void setIdle(Double idle) {
				this.idle = idle;
			}
		}

		public static class TaskCounts {
			private Integer succeeded;
			private Integer failed;

			public Integer getSucceeded() {
				return succeeded;
			}

			public void setSucceeded(Integer succeeded) {
				this.succeeded = succeeded;
			}

			public Integer getFailed() {
				return failed;
			}

			public void setFailed(Integer failed) {
				this.failed = failed;
			}
		}
	}

}
