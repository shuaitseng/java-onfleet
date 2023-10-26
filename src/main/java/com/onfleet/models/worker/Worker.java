package com.onfleet.models.worker;

import com.onfleet.models.Metadata;

import java.util.List;

public class Worker {
	private WorkerAccountStatus accountStatus;
	private String activeTask;
	private WorkerAdditionalCapacities additionalCapacities;
	private WorkerAddresses addresses;
	private WorkerAnalytics analytics;
	private Double capacity;
	private Double delayTime;
	private String displayName;
	private Boolean hasRecentlyUsedSpoofedLocations;
	private String id;
	private String imageUrl;
	private List<Double> location;
	private List<Metadata> metadata;
	private String name;
	private Boolean onDuty;
	private String organization;
	private String phone;
	private List<String> tasks;
	private List<String> teams;
	private Long timeCreated;
	private Long timeLastModified;
	private Long timeLastSeen;
	private WorkerUserData userData;
	private String timezone;
	private WorkerVehicle vehicle;

	public WorkerAccountStatus getAccountStatus() {
		return accountStatus;
	}

	public String getActiveTask() {
		return activeTask;
	}

	public WorkerAdditionalCapacities getAdditionalCapacities() {
		return additionalCapacities;
	}

	public WorkerAddresses getAddresses() {
		return addresses;
	}

	public WorkerAnalytics getAnalytics() {
		return analytics;
	}

	public Double getCapacity() {
		return capacity;
	}

	public Double getDelayTime() {
		return delayTime;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Boolean getHasRecentlyUsedSpoofedLocations() {
		return hasRecentlyUsedSpoofedLocations;
	}

	public String getId() {
		return id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public List<Double> getLocation() {
		return location;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public String getName() {
		return name;
	}

	public Boolean getOnDuty() {
		return onDuty;
	}

	public String getOrganization() {
		return organization;
	}

	public String getPhone() {
		return phone;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public List<String> getTeams() {
		return teams;
	}

	public Long getTimeCreated() {
		return timeCreated;
	}

	public Long getTimeLastModified() {
		return timeLastModified;
	}

	public Long getTimeLastSeen() {
		return timeLastSeen;
	}

	public WorkerUserData getUserData() {
		return userData;
	}

	public String getTimezone() {
		return timezone;
	}

	public WorkerVehicle getVehicle() {
		return vehicle;
	}
}
