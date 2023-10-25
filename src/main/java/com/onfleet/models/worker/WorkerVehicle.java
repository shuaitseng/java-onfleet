package com.onfleet.models.worker;

import com.onfleet.models.VehicleType;

public class WorkerVehicle {
	private final VehicleType type;
	private final String description;
	private final String licensePlate;
	private final String color;

	private WorkerVehicle(Builder builder) {
		type = builder.type;
		description = builder.description;
		licensePlate = builder.licensePlate;
		color = builder.color;
	}

	public VehicleType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public String getColor() {
		return color;
	}

	public static class Builder {
		private final VehicleType type;
		private String description;
		private String licensePlate;
		private String color;

		public Builder(VehicleType type) {
			this.type = type;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
			return this;
		}

		public Builder setColor(String color) {
			this.color = color;
			return this;
		}

		public WorkerVehicle build() {
			return new WorkerVehicle(this);
		}
	}

}
