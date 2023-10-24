package com.onfleet.models.task;

import com.onfleet.models.Metadata;

import java.util.List;

public class TaskCloneOverridesParam {
	private Long completeAfter;
	private Long completeBefore;
	private Object destination; // Destination can be a string destination id or a Destination object
	private List<Metadata> metadata;
	private String notes;
	private Boolean pickupTask;
	private Object recipients; // Recipients can be a String array of recipient ids or an array of recipient objects
	private Double serviceTime;

	public Long getCompleteAfter() {
		return completeAfter;
	}

	public void setCompleteAfter(Long completeAfter) {
		this.completeAfter = completeAfter;
	}

	public Long getCompleteBefore() {
		return completeBefore;
	}

	public void setCompleteBefore(Long completeBefore) {
		this.completeBefore = completeBefore;
	}

	public Object getDestination() {
		return destination;
	}

	public void setDestination(Object destination) {
		this.destination = destination;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Boolean getPickupTask() {
		return pickupTask;
	}

	public void setPickupTask(Boolean pickupTask) {
		this.pickupTask = pickupTask;
	}

	public Object getRecipients() {
		return recipients;
	}

	public void setRecipients(Object recipients) {
		this.recipients = recipients;
	}

	public Double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Double serviceTime) {
		this.serviceTime = serviceTime;
	}
}
