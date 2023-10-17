package com.onfleet.models.task;

import java.util.List;

public class TaskCompletionDetails {
	private List<Object> actions;
	private Double distance;
	private TaskCompletionEvent events;
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

	public void setActions(List<Object> actions) {
		this.actions = actions;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public TaskCompletionEvent getEvents() {
		return events;
	}

	public void setEvents(TaskCompletionEvent events) {
		this.events = events;
	}

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

	public List<Double> getFirstLocation() {
		return firstLocation;
	}

	public void setFirstLocation(List<Double> firstLocation) {
		this.firstLocation = firstLocation;
	}

	public List<Double> getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(List<Double> lastLocation) {
		this.lastLocation = lastLocation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhotoUploadId() {
		return photoUploadId;
	}

	public void setPhotoUploadId(String photoUploadId) {
		this.photoUploadId = photoUploadId;
	}

	public List<String> getPhotoUploadIds() {
		return photoUploadIds;
	}

	public void setPhotoUploadIds(List<String> photoUploadIds) {
		this.photoUploadIds = photoUploadIds;
	}

	public String getSignatureUploadId() {
		return signatureUploadId;
	}

	public void setSignatureUploadId(String signatureUploadId) {
		this.signatureUploadId = signatureUploadId;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public List<Object> getUnavailableAttachments() {
		return unavailableAttachments;
	}

	public void setUnavailableAttachments(List<Object> unavailableAttachments) {
		this.unavailableAttachments = unavailableAttachments;
	}
}
