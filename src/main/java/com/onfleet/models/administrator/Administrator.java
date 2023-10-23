package com.onfleet.models.administrator;


import com.onfleet.models.Metadata;

import java.util.List;

public class Administrator {
	private String name;
	private String email;
	private String phone;
	private Boolean isReadOnly;
	private AdministratorType type;
	private String id;
	private Long timeCreated;
	private Long timeLastModified;
	private String organization;
	private Boolean isAccountOwner;
	private Boolean isActive;
	private List<Metadata> metadata;
	private List<String> teams;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		isReadOnly = readOnly;
	}

	public AdministratorType getType() {
		return type;
	}

	public void setType(AdministratorType type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public void setTimeLastModified(Long timeLastModified) {
		this.timeLastModified = timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public Boolean getAccountOwner() {
		return isAccountOwner;
	}

	public void setAccountOwner(Boolean accountOwner) {
		isAccountOwner = accountOwner;
	}

	public void setAccountOwner(boolean accountOwner) {
		isAccountOwner = accountOwner;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
	}

}
