package com.onfleet.models.destination;

public class Address {
	private String name;
	private String number;
	private String street;
	private String apartment;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private String unparsed;

	public Address(String number, String street, String city, String country) {
		this.number = number;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	private Address(Builder builder) {
		this.name = builder.name;
		this.number = builder.number;
		this.street = builder.street;
		this.apartment = builder.apartment;
		this.city = builder.city;
		this.state = builder.state;
		this.postalCode = builder.postalCode;
		this.country = builder.country;
		this.unparsed = builder.unparsed;
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
		private String name;
		private String number;
		private String street;
		private String apartment;
		private String city;
		private String state;
		private String postalCode;
		private String country;
		private String unparsed;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setNumber(String number) {
			this.number = number;
			return this;
		}

		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder setApartment(String apartment) {
			this.apartment = apartment;
			return this;
		}

		public Builder setCity(String city) {
			this.city = city;
			return this;
		}

		public Builder setState(String state) {
			this.state = state;
			return this;
		}

		public Builder setPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder setCountry(String country) {
			this.country = country;
			return this;
		}

		public Builder setUnparsed(String unparsed) {
			this.unparsed = unparsed;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
	}
}
