package com.onfleet.models;

import java.util.List;

public class CompletionDetails {
	private String failureNotes;
	private String failureReason;
	private List<String> events;
	private List<String> actions;
	private Long time;
	private List<String> firstLocation;
	private List<String> lastLocation;
	private List<String> unavailableAttachments;

	public String getFailureNotes() {
		return failureNotes;
	}

	public void setFailureNotes(String failureNotes) {
		this.failureNotes = failureNotes;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}

	public List<String> getActions() {
		return actions;
	}

	public void setActions(List<String> actions) {
		this.actions = actions;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public List<String> getFirstLocation() {
		return firstLocation;
	}

	public void setFirstLocation(List<String> firstLocation) {
		this.firstLocation = firstLocation;
	}

	public List<String> getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(List<String> lastLocation) {
		this.lastLocation = lastLocation;
	}

	public List<String> getUnavailableAttachments() {
		return unavailableAttachments;
	}

	public void setUnavailableAttachments(List<String> unavailableAttachments) {
		this.unavailableAttachments = unavailableAttachments;
	}
}
