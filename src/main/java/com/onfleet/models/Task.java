package com.onfleet.models;


import java.util.ArrayList;

public class Task<T> {
    private String merchant;
    private String executor;
    private String destination;
    private ArrayList<T> recipients;
    private Integer completeAfter;
    private Integer completeBefore;
    private Boolean pickupTask;
    private ArrayList<String> dependencies;
    private String notes;
    /*private var autoAssign;*/
    /*private var container;*/
    private Integer quantity;
    private Integer serviceTime;
    private String recipientName;
    private String recipientNotes;
    private Boolean recipientSkipSMSNotifications;
    private Boolean useMerchantForProxy;
    /*private Requirements requirements;*/
    private Boolean scanOnlyRequiredBarcodes;
    /*private Appeareance appeareance;*/
}
