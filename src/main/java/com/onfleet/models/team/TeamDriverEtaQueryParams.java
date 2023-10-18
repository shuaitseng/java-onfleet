package com.onfleet.models.team;

import com.onfleet.models.VehicleType;

public class TeamDriverEtaQueryParams {
	private String dropoffLocation;
	private String pickupLocation;
	private Long pickupTime;
	private VehicleType[] restrictedVehicleTypes;
	private Long serviceTime;

	public String getDropoffLocation() {
		return dropoffLocation;
	}

	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Long getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Long pickupTime) {
		this.pickupTime = pickupTime;
	}

	public VehicleType[] getRestrictedVehicleTypes() {
		return restrictedVehicleTypes;
	}

	public void setRestrictedVehicleTypes(VehicleType[] restrictedVehicleTypes) {
		this.restrictedVehicleTypes = restrictedVehicleTypes;
	}

	public Long getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Long serviceTime) {
		this.serviceTime = serviceTime;
	}
}
