package com.onfleet.models;


import java.util.List;

public class Task {
    private String id;
    private long timeCreated;
    private long timeLastModified;
    private String organization;
    private String shortId;
    private String trackingURL;
    private String worker;
    private String merchant;
    private String executor;
    private String creator;
    private List<String> dependencies;
    private int state;
    private Boolean pickupTask;
    private String notes;
    private CompletionDetails completionDetails;
    private List<String> feedback;
    private List<String> metadata;
    private AdditionalQuantities additionalQuantities;
    private int serviceTime;
    private Identity identity;
    private Appearance appearance;
    private Boolean scanOnlyRequiredBarcodes;
    private Container container;
    private Boolean trackingViewed;
    private List<String> recipients;
    private Long delayTime;
    private Long estimatedCompletionTime;
    private Long estimatedArrivalTime;
    private Long eta;
    private Destination destination;

}
