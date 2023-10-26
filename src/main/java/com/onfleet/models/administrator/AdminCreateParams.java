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
