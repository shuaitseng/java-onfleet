package com.onfleet.models.worker;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WorkerScheduleEntries {
	@JsonProperty("entries")
	private List<WorkerScheduleEntry> entries;

	public List<WorkerScheduleEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<WorkerScheduleEntry> entries) {
		this.entries = entries;
	}

	public void addEntry(WorkerScheduleEntry entry) {
		this.entries.add(entry);
	}
}
