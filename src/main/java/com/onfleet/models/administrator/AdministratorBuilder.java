package com.onfleet.models.administrator;

public class AdministratorBuilder {
	private String name;
	private String email;
	private String phone;
	private Boolean isReadOnly;
	private Administrator.Type type;

	public AdministratorBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public AdministratorBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public AdministratorBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public AdministratorBuilder setIsReadOnly(Boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
		return this;
	}

	public AdministratorBuilder setType(Administrator.Type type) {
		this.type = type;
		return this;
	}

	public Administrator build() {
		return new Administrator(name, email, phone, isReadOnly, type);
	}
}