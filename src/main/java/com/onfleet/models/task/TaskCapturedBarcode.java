package com.onfleet.models.task;

import java.util.List;

public class TaskCapturedBarcode {
	String data;
	String id;
	List<Double> location;
	String symbology;
	Long time;
	Boolean wasRequested;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Double> getLocation() {
		return location;
	}

	public void setLocation(List<Double> location) {
		this.location = location;
	}

	public String getSymbology() {
		return symbology;
	}

	public void setSymbology(String symbology) {
		this.symbology = symbology;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Boolean getWasRequested() {
		return wasRequested;
	}

	public void setWasRequested(Boolean wasRequested) {
		this.wasRequested = wasRequested;
	}
}
