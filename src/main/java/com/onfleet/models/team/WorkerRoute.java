package com.onfleet.models.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onfleet.models.worker.RouteStep;
import com.onfleet.models.VehicleType;

import java.util.List;

public class WorkerRoute {
	private String workerId;
	@JsonProperty("vehicle")
	private VehicleType vehicleType;
	private List<RouteStep> steps;

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

	public List<RouteStep> getSteps() {
		return steps;
	}

	public void setSteps(List<RouteStep> steps) {
		this.steps = steps;
	}
}
