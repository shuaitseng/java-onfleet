package com.onfleet.models;

import java.util.List;

public class Metadata {
	private String name;
	private String type;
	private String subType;
	private List<MetadataVisibility> metadataVisibility;
	private Object value;

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
}
