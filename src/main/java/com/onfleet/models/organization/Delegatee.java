package com.onfleet.models.organization;


public class Delegatee extends Organization {
	private String driverSupportEmail;
	private String image;
	private Boolean isFulfillment;

	@Override
	public String getDriverSupportEmail() {
		return driverSupportEmail;
	}

	@Override
	public void setDriverSupportEmail(String driverSupportEmail) {
		this.driverSupportEmail = driverSupportEmail;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getFulfillment() {
		return isFulfillment;
	}

	public void setFulfillment(Boolean fulfillment) {
		isFulfillment = fulfillment;
	}
}
