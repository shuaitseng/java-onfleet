package com.onfleet.models.team;

import com.onfleet.models.VehicleType;

import java.util.List;

public class TeamDriverEtaQueryParams {
	private String dropoffLocation;
	private String pickupLocation;
	private Long pickupTime;
	private List<VehicleType> restrictedVehicleTypes;
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

	public String getPickupLocation() {
		return pickupLocation;
	}

	public Long getPickupTime() {
		return pickupTime;
	}

	public List<VehicleType> getRestrictedVehicleTypes() {
		return restrictedVehicleTypes;
	}

	public Long getServiceTime() {
		return serviceTime;
	}

	public static class Builder {
		private String dropoffLocation;
		private String pickupLocation;
		private Long pickupTime;
		private List<VehicleType> restrictedVehicleTypes;
		private Long serviceTime;

		public Builder setDropoffLocation(String dropoffLocation) {
			this.dropoffLocation = dropoffLocation;
			return this;
		}

		public Builder setPickupLocation(String pickupLocation) {
			this.pickupLocation = pickupLocation;
			return this;
		}

		public Builder setPickupTime(Long pickupTime) {
			this.pickupTime = pickupTime;
			return this;
		}

		public Builder setRestrictedVehicleTypes(List<VehicleType> restrictedVehicleTypes) {
			this.restrictedVehicleTypes = restrictedVehicleTypes;
			return this;
		}

		public Builder setServiceTime(Long serviceTime) {
			this.serviceTime = serviceTime;
			return this;
		}

		public TeamDriverEtaQueryParams build() {
			return new TeamDriverEtaQueryParams(this);
		}
	}
}
