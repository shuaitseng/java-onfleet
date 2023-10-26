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

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Boolean getReadOnly() {
		return isReadOnly;
	}

	public AdministratorType getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public String getOrganization() {
		return organization;
	}

	public Boolean isActive() {
		return isActive;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public Boolean isAccountOwner() {
		return isAccountOwner;
	}

	public List<String> getTeams() {
		return teams;
	}


}
