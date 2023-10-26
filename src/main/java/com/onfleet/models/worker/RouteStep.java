package com.onfleet.models.worker;

import java.util.List;

public class RouteStep {
	private List<Double> location;
	private Double travelTime;
	private Double distance;
	private Double serviceTime;
	private Integer arrivalTime;
	private Integer completionTime;

	public List<Double> getLocation() {
		return location;
	}

	public Double getTravelTime() {
		return travelTime;
	}

	public Double getDistance() {
		return distance;
	}

	public Double getServiceTime() {
		return serviceTime;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public Integer getCompletionTime() {
		return completionTime;
	}
}
