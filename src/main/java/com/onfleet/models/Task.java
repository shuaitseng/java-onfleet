package com.onfleet.models;


import java.util.List;

public class Task {
    private String id;
    private Long timeCreated;
    private Long timeLastModified;
    private Long completeAfter;
    private Long completeBefore;
    private String organization;
    private String shortId;
    private String trackingURL;
    private String worker;
    private String merchant;
    private String executor;
    private String creator;
    private List<String> dependencies;
    private Integer state;
    private Boolean pickupTask;
    private String notes;
    private CompletionDetails completionDetails;
    private List<String> feedback;
    private List<Metadata> metadata;
    private AdditionalQuantities additionalQuantities;
    private Integer serviceTime;
    private Identity identity;
    private Appearance appearance;
    private Boolean scanOnlyRequiredBarcodes;
    private Container container;
    private Boolean trackingViewed;
    private List<Recipient> recipients;
    private Long delayTime;
    private Long estimatedCompletionTime;
    private Long estimatedArrivalTime;
    private Long eta;
    private Object destination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeLastModified() {
        return timeLastModified;
    }

    public void setTimeLastModified(long timeLastModified) {
        this.timeLastModified = timeLastModified;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getTrackingURL() {
        return trackingURL;
    }

    public void setTrackingURL(String trackingURL) {
        this.trackingURL = trackingURL;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Boolean getPickupTask() {
        return pickupTask;
    }

    public void setPickupTask(Boolean pickupTask) {
        this.pickupTask = pickupTask;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public CompletionDetails getCompletionDetails() {
        return completionDetails;
    }

    public void setCompletionDetails(CompletionDetails completionDetails) {
        this.completionDetails = completionDetails;
    }

    public List<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(List<String> feedback) {
        this.feedback = feedback;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public AdditionalQuantities getAdditionalQuantities() {
        return additionalQuantities;
    }

    public void setAdditionalQuantities(AdditionalQuantities additionalQuantities) {
        this.additionalQuantities = additionalQuantities;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public Boolean getScanOnlyRequiredBarcodes() {
        return scanOnlyRequiredBarcodes;
    }

    public void setScanOnlyRequiredBarcodes(Boolean scanOnlyRequiredBarcodes) {
        this.scanOnlyRequiredBarcodes = scanOnlyRequiredBarcodes;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Boolean getTrackingViewed() {
        return trackingViewed;
    }

    public void setTrackingViewed(Boolean trackingViewed) {
        this.trackingViewed = trackingViewed;
    }

    public List<Recipient> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    public Long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Long delayTime) {
        this.delayTime = delayTime;
    }

    public Long getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public void setEstimatedCompletionTime(Long estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }

    public Long getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Long estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public Long getEta() {
        return eta;
    }

    public void setEta(Long eta) {
        this.eta = eta;
    }

    public Object getDestination() {
        return destination;
    }

    public void setDestination(Object destination) {
        this.destination = destination;
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
}
