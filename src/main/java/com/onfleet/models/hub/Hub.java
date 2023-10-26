package com.onfleet.models.hub;


import com.onfleet.models.destination.Address;

import java.util.List;

public class Hub {
	private Address address;
	private String id;
	private List<Double> location;
	private String name;
	private List<String> teams;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Double> getLocation() {
		return location;
	}

	public Address getAddress() {
		return address;
	}

	public List<String> getTeams() {
		return teams;
	}
}
