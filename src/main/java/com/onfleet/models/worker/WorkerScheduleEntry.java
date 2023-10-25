package com.onfleet.models.worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkerScheduleEntry {
	private String date;
	private List<List<Long>> shifts;
	private String timezone;

	public WorkerScheduleEntry(String date, String timezone) {
		this.date = date;
		this.timezone = timezone;
		this.shifts = new ArrayList<>();
	}

	private WorkerScheduleEntry(Builder builder) {
		date = builder.date;
		shifts = builder.shifts;
		timezone = builder.timezone;
	}

	public void addShift(long startTime, long endTime) {
		List<Long> shift = Arrays.asList(startTime, endTime);
		shifts.add(shift);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<List<Long>> getShifts() {
		return shifts;
	}

	public void setShifts(List<List<Long>> shifts) {
		this.shifts = shifts;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public static class Builder {
		private String date;
		private List<List<Long>> shifts;
		private String timezone;

		public Builder setDate(String date) {
			this.date = date;
			return this;
		}

		public Builder setShifts(List<List<Long>> shifts) {
			this.shifts = shifts;
			return this;
		}

		public Builder addShift(Long from, Long to) {
			if (shifts == null) {
				shifts = new ArrayList<>();
			}
			shifts.add(Arrays.asList(from, to));
			return this;
		}

		public Builder setTimezone(String timezone) {
			this.timezone = timezone;
			return this;
		}

		public WorkerScheduleEntry build() {
			return new WorkerScheduleEntry(this);
		}
	}
}
