package com.onfleet.models.task;


import com.onfleet.models.Destination;
import com.onfleet.models.Metadata;
import com.onfleet.models.Recipient;

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

	public TaskAppearance getAppearance() {
		return appearance;
	}

	public void setAppearance(TaskAppearance appearance) {
		this.appearance = appearance;
	}

	public TaskAutoAssignParam getAutoAssign() {
		return autoAssign;
	}

	public void setAutoAssign(TaskAutoAssignParam autoAssign) {
		this.autoAssign = autoAssign;
	}

	public List<TaskBarcode> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<TaskBarcode> barcodes) {
		this.barcodes = barcodes;
	}

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

	public TaskContainer getContainer() {
		return container;
	}

	public void setContainer(TaskContainer container) {
		this.container = container;
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public Object getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void setDestination(String destinationId) {
		this.destination = destinationId;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientNotes() {
		return recipientNotes;
	}

	public void setRecipientNotes(String recipientNotes) {
		this.recipientNotes = recipientNotes;
	}

	public Object getRecipients() {
		return recipients;
	}

	public void setRecipients(String[] recipientsIds) {
		this.recipients = recipientsIds;
	}

	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
	}

	public Boolean getRecipientSkipSmsNotifications() {
		return recipientSkipSmsNotifications;
	}

	public void setRecipientSkipSmsNotifications(Boolean recipientSkipSmsNotifications) {
		this.recipientSkipSmsNotifications = recipientSkipSmsNotifications;
	}

	public TaskCompletionRequirementsParam getRequirements() {
		return requirements;
	}

	public void setRequirements(TaskCompletionRequirementsParam requirements) {
		this.requirements = requirements;
	}

	public Boolean getScanOnlyRequiredBarcodes() {
		return scanOnlyRequiredBarcodes;
	}

	public void setScanOnlyRequiredBarcodes(Boolean scanOnlyRequiredBarcodes) {
		this.scanOnlyRequiredBarcodes = scanOnlyRequiredBarcodes;
	}

	public Double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Double serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Boolean getUseMerchantForProxy() {
		return useMerchantForProxy;
	}

	public void setUseMerchantForProxy(Boolean useMerchantForProxy) {
		this.useMerchantForProxy = useMerchantForProxy;
	}
}
