package com.onfleet.models;

public class RouteStep {
	private Long[] location;
	private Integer travelTime;
	private Integer distance;
	private Integer serviceTime;
	private Integer arrivalTime;
	private Integer completionTime;

	public Long[] getLocation() {
		return location;
	}

	public void setLocation(Long[] location) {
		this.location = location;
	}

	public Integer getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Integer travelTime) {
		this.travelTime = travelTime;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Integer serviceTime) {
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
