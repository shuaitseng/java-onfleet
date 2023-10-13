package com.onfleet.models;

public class TaskOverrides {
	private String recipientName;
	private String recipientNotes;
	private Boolean recipientSkipSMSNotifications;
	private Boolean useMerchantForProxy;

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

	public Boolean getRecipientSkipSMSNotifications() {
		return recipientSkipSMSNotifications;
	}

	public void setRecipientSkipSMSNotifications(Boolean recipientSkipSMSNotifications) {
		this.recipientSkipSMSNotifications = recipientSkipSMSNotifications;
	}

	public Boolean getUseMerchantForProxy() {
		return useMerchantForProxy;
	}

	public void setUseMerchantForProxy(Boolean useMerchantForProxy) {
		this.useMerchantForProxy = useMerchantForProxy;
	}
}
