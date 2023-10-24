package com.onfleet.models;

import java.util.List;

public class Metadata {
	private String name;
	private String type;
	private String subType;
	private List<MetadataVisibility> metadataVisibility;
	private Object value;

	private Metadata(Builder builder) {
		name = builder.name;
		type = builder.type;
		subType = builder.subType;
		metadataVisibility = builder.metadataVisibility;
		value = builder.value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public List<MetadataVisibility> getVisibility() {
		return metadataVisibility;
	}

	public void setVisibility(List<MetadataVisibility> metadataVisibility) {
		this.metadataVisibility = metadataVisibility;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public static class Builder {
		private String name;
		private String type;
		private String subType;
		private List<MetadataVisibility> metadataVisibility;
		private Object value;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setSubType(String subType) {
			this.subType = subType;
			return this;
		}

		public Builder setMetadataVisibility(List<MetadataVisibility> metadataVisibility) {
			this.metadataVisibility = metadataVisibility;
			return this;
		}

		public Builder setValue(Object value) {
			this.value = value;
			return this;
		}

		public Metadata build() {
			return new Metadata(this);
		}
	}

}
