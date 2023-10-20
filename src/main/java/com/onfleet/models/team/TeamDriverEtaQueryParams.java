package com.onfleet.models.team;

import com.onfleet.models.VehicleType;

public class TeamDriverEtaQueryParams {
	private String dropoffLocation;
	private String pickupLocation;
	private Long pickupTime;
	private VehicleType[] restrictedVehicleTypes;
	private Long serviceTime;

	private TeamDriverEtaQueryParams(Builder builder) {
		this.dropoffLocation = builder.dropoffLocation;
		this.pickupLocation = builder.pickupLocation;
		this.pickupTime = builder.pickupTime;
		this.restrictedVehicleTypes = builder.restrictedVehicleTypes;
		this.serviceTime = builder.serviceTime;
	}

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

	public static class Builder {
		private String dropoffLocation;
		private String pickupLocation;
		private Long pickupTime;
		private VehicleType[] restrictedVehicleTypes;
		private Long serviceTime;

		public Builder dropoffLocation(String dropoffLocation) {
			this.dropoffLocation = dropoffLocation;
			return this;
		}

		public Builder pickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
			return this;
		}

		public Builder pickupTime(Long pickupTime) {
			this.pickupTime = pickupTime;
			return this;
		}

		public Builder restrictedVehicleTypes(VehicleType[] restrictedVehicleTypes) {
			this.restrictedVehicleTypes = restrictedVehicleTypes;
			return this;
		}

		public Builder serviceTime(Long serviceTime) {
			this.serviceTime = serviceTime;
			return this;
		}

		public TeamDriverEtaQueryParams build() {
			return new TeamDriverEtaQueryParams(this);
		}
	}
}
