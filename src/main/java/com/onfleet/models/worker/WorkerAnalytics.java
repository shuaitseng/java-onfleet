package com.onfleet.models.worker;

import java.util.List;

public class WorkerAnalytics {
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
