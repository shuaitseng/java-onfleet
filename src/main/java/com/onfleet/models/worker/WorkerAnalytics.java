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

	public Distance getDistances() {
		return distances;
	}

	public Time getTimes() {
		return times;
	}

	public TaskCounts getTaskCounts() {
		return taskCounts;
	}

	public static class AnalyticsEvent {
		private String action;
		private Long time;

		public String getAction() {
			return action;
		}

		public Long getTime() {
			return time;
		}
	}

	public static class Distance {
		private double enroute;
		private double idle;

		public double getEnroute() {
			return enroute;
		}

		public double getIdle() {
			return idle;
		}
	}

	public static class Time {
		private Double enroute;
		private Double idle;

		public Double getEnroute() {
			return enroute;
		}

		public Double getIdle() {
			return idle;
		}
	}

	public static class TaskCounts {
		private Integer succeeded;
		private Integer failed;

		public Integer getSucceeded() {
			return succeeded;
		}

		public Integer getFailed() {
			return failed;
		}
	}
}
