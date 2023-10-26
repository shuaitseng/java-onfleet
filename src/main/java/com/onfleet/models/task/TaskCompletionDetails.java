package com.onfleet.models.task;

import java.util.List;

public class TaskCompletionDetails {
	private List<Object> actions;
	private Double distance;
	private List<TaskCompletionEvent> events;
	private String failureNotes;
	private String failureReason;
	private List<Double> firstLocation;
	private List<Double> lastLocation;
	private String notes;
	private String photoUploadId;
	private List<String> photoUploadIds;
	private String signatureUploadId;
	private Boolean success;
	private Double time;
	private List<Object> unavailableAttachments;

	public List<Object> getActions() {
		return actions;
	}

	public Double getDistance() {
		return distance;
	}

	public List<TaskCompletionEvent> getEvents() {
		return events;
	}

	public String getFailureNotes() {
		return failureNotes;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public List<Double> getFirstLocation() {
		return firstLocation;
	}

	public List<Double> getLastLocation() {
		return lastLocation;
	}

	public String getNotes() {
		return notes;
	}

	public String getPhotoUploadId() {
		return photoUploadId;
	}

	public List<String> getPhotoUploadIds() {
		return photoUploadIds;
	}

	public String getSignatureUploadId() {
		return signatureUploadId;
	}

	public Boolean getSuccess() {
		return success;
	}

	public Double getTime() {
		return time;
	}

	public List<Object> getUnavailableAttachments() {
		return unavailableAttachments;
	}

}
