package com.onfleet.models.task;

import java.util.List;

public class TaskCompletionDetails {
	/*Actions[] any                 `json:"actions"`*/
	private Double distance;
	private TaskCompletionEvent events;
	private String failureNotes;
	private String failureReason;
	private List<Double> FirstLocation;
	private List<Double> LastLocation;
	private String notes;
	private String photoUploadId;
	private List<String> photoUploadIds;
	private String signatureUploadId;
	private Boolean success;
	private Double time;
	/*UnavailableAttachments[] any                 `json:"unavailableAttachments"`*/
}
