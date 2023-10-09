package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScheduleEntries {
	@JsonProperty("entries")
	private List<ScheduleEntry> entries;

	public ScheduleEntries() {}

	public List<ScheduleEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ScheduleEntry> entries) {
		this.entries = entries;
	}
}
