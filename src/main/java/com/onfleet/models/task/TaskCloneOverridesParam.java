package com.onfleet.models.task;

import com.onfleet.models.Metadata;
import com.onfleet.models.destination.Destination;
import com.onfleet.models.recipient.Recipient;

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

	private TaskCloneOverridesParam(Builder builder) {
		completeAfter = builder.completeAfter;
		completeBefore = builder.completeBefore;
		destination = builder.destination;
		metadata = builder.metadata;
		notes = builder.notes;
		pickupTask = builder.pickupTask;
		recipients = builder.recipients;
	}

	public static class Builder {
		private Long completeAfter;
		private Long completeBefore;
		private Object destination;
		private List<Metadata> metadata;
		private String notes;
		private Boolean pickupTask;
		private Object recipients;

		public Builder setCompleteAfter(Long completeAfter) {
			this.completeAfter = completeAfter;
			return this;
		}

		public Builder setCompleteBefore(Long completeBefore) {
			this.completeBefore = completeBefore;
			return this;
		}

		public Builder setDestination(String destinationId) {
			this.destination = destinationId;
			return this;
		}

		public Builder setDestination(Destination destination) {
			this.destination = destination;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder setNotes(String notes) {
			this.notes = notes;
			return this;
		}

		public Builder setPickupTask(Boolean pickupTask) {
			this.pickupTask = pickupTask;
			return this;
		}

		public Builder setRecipients(String[] recipientsIds) {
			this.recipients = recipientsIds;
			return this;
		}

		public Builder setRecipients(List<Recipient> recipients) {
			this.recipients = recipients;
			return this;
		}

		public TaskCloneOverridesParam build() {
			return new TaskCloneOverridesParam(this);
		}
	}
}
