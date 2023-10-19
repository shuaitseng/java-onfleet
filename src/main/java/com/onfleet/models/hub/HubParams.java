package com.onfleet.models.hub;

import com.onfleet.models.destination.Address;

import java.util.List;

public class HubParams {
	private Address address;
	private String name;
	private List<String> teams;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}
}
