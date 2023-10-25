package com.onfleet.models.task;


import com.onfleet.models.destination.Destination;
import com.onfleet.models.Metadata;
import com.onfleet.models.recipient.Recipient;

import java.util.List;

public class TaskParams {
	private TaskAppearance appearance;
	private TaskAutoAssignParam autoAssign;
	private List<TaskBarcode> barcodes;
	private Long completeAfter;
	private Long completeBefore;
	private TaskContainer container;
	private List<String> dependencies;
	private Object destination; // can be a String or a Destination Object
	private String executor;
	private String merchant;
	private List<Metadata> metadata;
	private String notes;
	private Boolean pickupTask;
	private Double quantity;
	private String recipientName;
	private String recipientNotes;
	private Object recipients; // can be either a String array or a Recipient Object
	private Boolean recipientSkipSmsNotifications;
	private TaskCompletionRequirementsParam requirements;
	private Boolean scanOnlyRequiredBarcodes;
	private Double serviceTime;
	private Boolean useMerchantForProxy;

	private TaskParams(Builder builder) {
		this.appearance = builder.appearance;
		this.autoAssign = builder.autoAssign;
		this.barcodes = builder.barcodes;
		this.completeAfter = builder.completeAfter;
		this.completeBefore = builder.completeBefore;
		this.container = builder.container;
		this.dependencies = builder.dependencies;
		this.destination = builder.destination;
		this.executor = builder.executor;
		this.merchant = builder.merchant;
		this.metadata = builder.metadata;
		this.notes = builder.notes;
		this.pickupTask = builder.pickupTask;
		this.quantity = builder.quantity;
		this.recipientName = builder.recipientName;
		this.recipientNotes = builder.recipientNotes;
		this.recipients = builder.recipients;
		this.recipientSkipSmsNotifications = builder.recipientSkipSmsNotifications;
		this.requirements = builder.requirements;
		this.scanOnlyRequiredBarcodes = builder.scanOnlyRequiredBarcodes;
		this.serviceTime = builder.serviceTime;
		this.useMerchantForProxy = builder.useMerchantForProxy;
	}

	public static class Builder {
		private TaskAppearance appearance;
		private TaskAutoAssignParam autoAssign;
		private List<TaskBarcode> barcodes;
		private Long completeAfter;
		private Long completeBefore;
		private TaskContainer container;
		private List<String> dependencies;
		private Object destination;
		private String executor;
		private String merchant;
		private List<Metadata> metadata;
		private String notes;
		private Boolean pickupTask;
		private Double quantity;
		private String recipientName;
		private String recipientNotes;
		private Object recipients;
		private Boolean recipientSkipSmsNotifications;
		private TaskCompletionRequirementsParam requirements;
		private Boolean scanOnlyRequiredBarcodes;
		private Double serviceTime;
		private Boolean useMerchantForProxy;

		public Builder setAppearance(TaskAppearance appearance) {
			this.appearance = appearance;
			return this;
		}

		public Builder setAutoAssign(TaskAutoAssignParam autoAssign) {
			this.autoAssign = autoAssign;
			return this;
		}

		public Builder setBarcodes(List<TaskBarcode> barcodes) {
			this.barcodes = barcodes;
			return this;
		}

		public Builder setCompleteAfter(Long completeAfter) {
			this.completeAfter = completeAfter;
			return this;
		}

		public Builder setCompleteBefore(Long completeBefore) {
			this.completeBefore = completeBefore;
			return this;
		}

		public Builder setContainer(TaskContainer container) {
			this.container = container;
			return this;
		}

		public Builder setDependencies(List<String> dependencies) {
			this.dependencies = dependencies;
			return this;
		}

		public Builder setDestination(String destination) {
			this.destination = destination;
			return this;
		}

		public Builder setDestination(Destination destination) {
			this.destination = destination;
			return this;
		}

		public Builder setExecutor(String executor) {
			this.executor = executor;
			return this;
		}

		public Builder setMerchant(String merchant) {
			this.merchant = merchant;
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

		public Builder setQuantity(Double quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder setRecipientName(String recipientName) {
			this.recipientName = recipientName;
			return this;
		}

		public Builder setRecipientNotes(String recipientNotes) {
			this.recipientNotes = recipientNotes;
			return this;
		}

		public Builder setRecipients(String[] recipients) {
			this.recipients = recipients;
			return this;
		}

		public Builder setRecipients(List<Recipient> recipients) {
			this.recipients = recipients;
			return this;
		}

		public Builder setRecipientSkipSmsNotifications(Boolean recipientSkipSmsNotifications) {
			this.recipientSkipSmsNotifications = recipientSkipSmsNotifications;
			return this;
		}

		public Builder setRequirements(TaskCompletionRequirementsParam requirements) {
			this.requirements = requirements;
			return this;
		}

		public Builder setScanOnlyRequiredBarcodes(Boolean scanOnlyRequiredBarcodes) {
			this.scanOnlyRequiredBarcodes = scanOnlyRequiredBarcodes;
			return this;
		}

		public Builder setServiceTime(Double serviceTime) {
			this.serviceTime = serviceTime;
			return this;
		}

		public Builder setUseMerchantForProxy(Boolean useMerchantForProxy) {
			this.useMerchantForProxy = useMerchantForProxy;
			return this;
		}

		public TaskParams build() {
			return new TaskParams(this);
		}
	}
}
