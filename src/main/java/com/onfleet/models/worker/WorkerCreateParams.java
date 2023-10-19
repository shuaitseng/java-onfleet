package com.onfleet.models.worker;

import com.onfleet.models.Metadata;

import java.util.List;

public class WorkerCreateParams {
	private WorkerAddresses addresses;
	private Double capacity;
	private String displayName;
	private List<Metadata> metadata;
	private String name;
	private String phone;
	private List<String> teams;
	private WorkerVehicle workerVehicle;

	public WorkerAddresses getAddresses() {
		return addresses;
	}

	public void setAddresses(WorkerAddresses addresses) {
		this.addresses = addresses;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

	public WorkerVehicle getWorkerVehicle() {
		return workerVehicle;
	}

	public void setWorkerVehicle(WorkerVehicle workerVehicle) {
		this.workerVehicle = workerVehicle;
	}
}
