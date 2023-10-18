package com.onfleet.models.hub;


import com.onfleet.models.Address;

import java.util.List;

public class Hub {
	private Address address;
	private String id;
	private List<Double> location;
	private String name;
	private List<String> team;

	public Hub(String name, Address address, List<String> team) {
		this.name = name;
		this.address = address;
		this.team = team;
	}

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

	public List<Double> getLocation() {
		return location;
	}

	public void setLocation(List<Double> location) {
		this.location = location;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getTeam() {
		return team;
	}

	public void setTeam(List<String> team) {
		this.team = team;
	}
}
