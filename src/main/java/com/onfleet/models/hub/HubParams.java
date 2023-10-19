package com.onfleet.models.hub;

import com.onfleet.models.destination.Address;

import java.util.List;

public class HubParams {
	private Address address;
	private String name;
	private List<String> teams;

	private HubParams(Builder builder) {
		this.address = builder.address;
		this.name = builder.name;
		this.teams = builder.teams;
	}

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

	public static class Builder {
		private final Address address;
		private final String name;
		private List<String> teams;

		public Builder(Address address, String name) {
			this.address = address;
			this.name = name;
		}

		public Builder setTeams(List<String> teams) {
			this.teams = teams;
			return this;
		}

		public HubParams build() {
			return new HubParams(this);
		}
	}

}
