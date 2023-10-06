package com.onfleet.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hub {
	@JsonProperty("address")
	private Address address;
	@JsonProperty("team")
	private String[] team;
	@JsonProperty("name")
	private String name;

	public Hub(Address address, String[] team, String name) {
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

	public String[] getTeam() {
		return team;
	}

	public void setTeam(String[] team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
