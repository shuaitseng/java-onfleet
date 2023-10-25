package com.onfleet.models.administrator;

import com.onfleet.models.Metadata;

import java.util.List;

public class AdminUpdateParams {
	private final String email;
	private final List<Metadata> metadata;
	private final String name;
	private final String phone;

	private AdminUpdateParams(Builder builder) {
		this.email = builder.email;
		this.metadata = builder.metadata;
		this.name = builder.name;
		this.phone = builder.phone;
	}

	public static class Builder {
		private String email;
		private List<Metadata> metadata;
		private String name;
		private String phone;

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public AdminUpdateParams build() {
			return new AdminUpdateParams(this);
		}
	}

}
