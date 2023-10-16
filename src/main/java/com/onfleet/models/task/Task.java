package com.onfleet.models.task;


import com.onfleet.models.Destination;
import com.onfleet.models.Metadata;
import com.onfleet.models.Recipient;

import java.util.List;

// TODO: what can Feedback be?
public class Task {
	private TaskAdditionalQuantities additionalQuantities;
	private TaskAppearance appearance;
	private TaskBarcodeContainer barcodes;
	private Long completeAfter;
	private Long completeBefore;
	private TaskCompletionDetails completionDetails;
	private TaskContainer container;
	private String creator;
	private Double delayTime;
	private List<String> dependencies;
	private Destination destination;
	private Long estimatedArrivalTime;
	private Long estimatedCompletionTime;
	private Long eta;
	private String executor;
	/*Feedback                 []any                    `json:"feedback"`*/
	private String id;
	private TaskIdentity identity;
	private String merchant;
	private List<Metadata> metadata;
	private String notes;
	private String organization;
	private TaskOverrides overrides;
	private Boolean pickupTask;
	private Double quantity;
	private List<Recipient> recipients;
	private Boolean scanOnlyRequiredBarcodes;
	private Double serviceTime;
	private String shortId;
	private String sourceTaskId;
	private TaskState state;
	private Long timeCreated;
	private Long timeLastModified;
	private String trackingUrl;
	private Boolean trackingViewed;
	private String worker;

	public TaskAdditionalQuantities getAdditionalQuantities() {
		return additionalQuantities;
	}

	public void setAdditionalQuantities(TaskAdditionalQuantities additionalQuantities) {
		this.additionalQuantities = additionalQuantities;
	}

	public TaskAppearance getAppearance() {
		return appearance;
	}

	public void setAppearance(TaskAppearance appearance) {
		this.appearance = appearance;
	}

	public TaskBarcodeContainer getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(TaskBarcodeContainer barcodes) {
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

	public TaskCompletionDetails getCompletionDetails() {
		return completionDetails;
	}

	public void setCompletionDetails(TaskCompletionDetails completionDetails) {
		this.completionDetails = completionDetails;
	}

	public TaskContainer getContainer() {
		return container;
	}

	public void setContainer(TaskContainer container) {
		this.container = container;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Double getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(Double delayTime) {
		this.delayTime = delayTime;
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Long getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}

	public void setEstimatedArrivalTime(Long estimatedArrivalTime) {
		this.estimatedArrivalTime = estimatedArrivalTime;
	}

	public Long getEstimatedCompletionTime() {
		return estimatedCompletionTime;
	}

	public void setEstimatedCompletionTime(Long estimatedCompletionTime) {
		this.estimatedCompletionTime = estimatedCompletionTime;
	}

	public Long getEta() {
		return eta;
	}

	public void setEta(Long eta) {
		this.eta = eta;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TaskIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(TaskIdentity identity) {
		this.identity = identity;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public TaskOverrides getOverrides() {
		return overrides;
	}

	public void setOverrides(TaskOverrides overrides) {
		this.overrides = overrides;
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

	public List<Recipient> getRecipients() {
		return recipients;
	}

	public void setRecipients(List<Recipient> recipients) {
		this.recipients = recipients;
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

	public String getShortId() {
		return shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	public String getSourceTaskId() {
		return sourceTaskId;
	}

	public void setSourceTaskId(String sourceTaskId) {
		this.sourceTaskId = sourceTaskId;
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(Long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public String getTrackingUrl() {
		return trackingUrl;
	}

	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	public Boolean getTrackingViewed() {
		return trackingViewed;
	}

	public void setTrackingViewed(Boolean trackingViewed) {
		this.trackingViewed = trackingViewed;
	}

	public String getWorker() {
		return worker;
	}

	public void setWorker(String worker) {
		this.worker = worker;
	}
}
