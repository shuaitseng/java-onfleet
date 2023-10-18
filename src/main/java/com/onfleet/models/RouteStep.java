package com.onfleet.models;

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

	public void setLocation(List<Double> location) {
		this.location = location;
	}

	public Double getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Double travelTime) {
		this.travelTime = travelTime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Double serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Integer arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(Integer completionTime) {
		this.completionTime = completionTime;
	}
}
