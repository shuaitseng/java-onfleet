package com.onfleet.models;

public class Worker {
	private String id;
	private String name;
	private String phone;
	private String[] teams;
	private Vehicle vehicle;
	private int capacity;
	private String displayName;
	/*address.routing	object	Optional. This value is used to set the worker's address.*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String[] getTeams() {
		return teams;
	}

	public void setTeams(String[] teams) {
		this.teams = teams;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public static class Builder {
		private final Worker worker = new Worker();

		public Builder setId(String id) {
			worker.setId(id);
			return this;
		}

		public Builder setName(String name) {
			worker.setName(name);
			return this;
		}

		public Builder setPhone(String phone) {
			worker.setPhone(phone);
			return this;
		}

		public Builder setTeams(String[] teams) {
			worker.setTeams(teams);
			return this;
		}

		public Builder setVehicle(Vehicle vehicle) {
			worker.setVehicle(vehicle);
			return this;
		}

		public Builder setCapacity(int capacity) {
			worker.setCapacity(capacity);
			return this;
		}

		public Builder setdisplayName(String displayName) {
			worker.setDisplayName(displayName);
			return this;
		}

		public Worker build() {
			return worker;
		}
	}

}
