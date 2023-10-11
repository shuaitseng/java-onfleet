package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hub {
	private String id;
	@JsonProperty("name")
	private String name;
	private List<Double> location;
	@JsonProperty("address")
	private Address address;
	@JsonProperty("team")
	private List<String> team;

	// TODO: reorder constructor parameters
	public Hub(Address address, List<String> team, String name) {
		this.address = address;
		this.team = team;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
