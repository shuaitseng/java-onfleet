package com.onfleet.models.destination;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	@JsonProperty("name")
	private String name;
	@JsonProperty("number")
	private String number;
	@JsonProperty("street")
	private String street;
	@JsonProperty("apartment")
	private String apartment;
	@JsonProperty("city")
	private String city;
	@JsonProperty("state")
	private String state;
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonProperty("country")
	private String country;
	@JsonProperty("unparsed")
	private String unparsed;

	public Address() {
	}

	public Address(String number, String street, String city, String country) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public Address(String name, String number, String street, String apartment, String city, String state, String postalCode, String country, String unparsed) {
		this(number, street, city, country);
		this.name = name;
		this.apartment = apartment;
		this.state = state;
		this.postalCode = postalCode;
		this.unparsed = unparsed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUnparsed() {
		return unparsed;
	}

	public void setUnparsed(String unparsed) {
		this.unparsed = unparsed;
	}

	public static class Builder {
		private final Address address = new Address();

		public Builder setName(String name) {
			address.setName(name);
			return this;
		}

		public Builder setNumber(String number) {
			address.setNumber(number);
			return this;
		}

		public Builder setStreet(String street) {
			address.setStreet(street);
			return this;
		}

		public Builder setApartment(String apartment) {
			address.setApartment(apartment);
			return this;
		}

		public Builder setCity(String city) {
			address.setCity(city);
			return this;
		}

		public Builder setState(String state) {
			address.setState(state);
			return this;
		}

		public Builder setPostalCode(String postalCode) {
			address.setPostalCode(postalCode);
			return this;
		}

		public Builder setCountry(String country) {
			address.setCountry(country);
			return this;
		}

		public Builder setUnparsed(String unparsed) {
			address.setUnparsed(unparsed);
			return this;
		}

		public Address build() {
			return address;
		}
	}
}
