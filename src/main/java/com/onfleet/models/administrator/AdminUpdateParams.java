package com.onfleet.models.administrator;

import com.onfleet.models.Metadata;

import java.util.List;

public class AdminUpdateParams {
	private String email;
	private List<Metadata> metadata;
	private String name;
	private String phone;

	private AdminUpdateParams(Builder builder) {
		this.email = builder.email;
		this.metadata = builder.metadata;
		this.name = builder.name;
		this.phone = builder.phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
