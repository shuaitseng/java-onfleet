package com.onfleet.models.worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkerScheduleEntry {
	private String date;
	private List<List<Long>> shifts;
	private String timezone;

	public WorkerScheduleEntry() {
	}

	public WorkerScheduleEntry(String date, String timezone) {
		this.date = date;
		this.timezone = timezone;
		this.shifts = new ArrayList<>();
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
}