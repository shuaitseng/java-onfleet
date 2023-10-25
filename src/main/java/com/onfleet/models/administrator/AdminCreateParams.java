package com.onfleet.models.administrator;

import com.onfleet.models.Metadata;

import java.util.List;

public class AdminCreateParams {
	private String email;
	private Boolean isReadOnly;
	private List<Metadata> metadata;
	private String name;
	private String phone;
	private AdministratorType type;

	private AdminCreateParams(Builder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.email = builder.email;
		this.phone = builder.phone;
		this.isReadOnly = builder.isReadOnly;
		this.metadata = builder.metadata;
	}

	/*public String getEmail() {
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

	public AdministratorType getType() {
		return type;
	}

	public void setType(AdministratorType type) {
		this.type = type;
	}*/

	public static class Builder {
		private final String email;
		private final String name;
		private final AdministratorType type;
		private Boolean isReadOnly;
		private List<Metadata> metadata;
		private String phone;

		public Builder(String name, String email, AdministratorType type) {
			this.name = name;
			this.email = email;
			this.type = type;
		}

		public Builder setIsReadOnly(Boolean isReadOnly) {
			this.isReadOnly = isReadOnly;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public AdminCreateParams build() {
			return new AdminCreateParams(this);
		}
	}
}
