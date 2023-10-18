package com.onfleet.models.administrator;

import com.onfleet.models.Metadata;

import java.util.List;

public class AdminCreateParams {
	private String email;
	private Boolean isReadOnly;
	private List<Metadata> metadata;
	private String name;
	private String phone;
	private String type;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(boolean readOnly) {
		isReadOnly = readOnly;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
