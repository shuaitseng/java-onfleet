package com.onfleet.models.organization;


public class Delegatee extends Organization {
	private Boolean isFulfillment;

	public Boolean getFulfillment() {
		return isFulfillment;
	}

	public void setFulfillment(Boolean fulfillment) {
		isFulfillment = fulfillment;
	}
}
