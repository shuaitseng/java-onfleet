package com.onfleet.models.task;

public class TaskOverrides {
	private String recipientName;
	private String recipientNotes;
	private Boolean recipientSkipSMSNotifications;
	private Boolean useMerchantForProxy;

	public String getRecipientName() {
		return recipientName;
	}

	public String getRecipientNotes() {
		return recipientNotes;
	}

	public Boolean getRecipientSkipSMSNotifications() {
		return recipientSkipSMSNotifications;
	}

	public Boolean getUseMerchantForProxy() {
		return useMerchantForProxy;
	}
}
