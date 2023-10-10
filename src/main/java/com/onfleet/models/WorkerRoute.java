package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkerRoute {
	private String workerId;
	@JsonProperty("vehicle")
	private VehicleType vehicleType;
	private RouteStep steps;

	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public RouteStep getSteps() {
		return steps;
	}

	public void setSteps(RouteStep steps) {
		this.steps = steps;
	}
}
