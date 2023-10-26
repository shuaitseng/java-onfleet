package com.onfleet.models.team;

import com.google.gson.annotations.SerializedName;
import com.onfleet.models.worker.RouteStep;
import com.onfleet.models.VehicleType;

import java.util.List;

public class WorkerRoute {
	private String workerId;
	@SerializedName("vehicle")
	private VehicleType vehicleType;
	private List<RouteStep> steps;

	public String getWorkerId() {
		return workerId;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public List<RouteStep> getSteps() {
		return steps;
	}
}
