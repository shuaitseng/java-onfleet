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

	public void setAccountStatus(WorkerAccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getActiveTask() {
		return activeTask;
	}

	public void setActiveTask(String activeTask) {
		this.activeTask = activeTask;
	}

	public WorkerAdditionalCapacities getAdditionalCapacities() {
		return additionalCapacities;
	}

	public void setAdditionalCapacities(WorkerAdditionalCapacities additionalCapacities) {
		this.additionalCapacities = additionalCapacities;
	}

	public WorkerAddresses getAddresses() {
		return addresses;
	}

	public void setAddresses(WorkerAddresses addresses) {
		this.addresses = addresses;
	}

	public WorkerAnalytics getAnalytics() {
		return analytics;
	}

	public void setAnalytics(WorkerAnalytics analytics) {
		this.analytics = analytics;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Double getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(Double delayTime) {
		this.delayTime = delayTime;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Boolean getHasRecentlyUsedSpoofedLocations() {
		return hasRecentlyUsedSpoofedLocations;
	}

	public void setHasRecentlyUsedSpoofedLocations(Boolean hasRecentlyUsedSpoofedLocations) {
		this.hasRecentlyUsedSpoofedLocations = hasRecentlyUsedSpoofedLocations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<Double> getLocation() {
		return location;
	}

	public void setLocation(List<Double> location) {
		this.location = location;
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

	public Boolean getOnDuty() {
		return onDuty;
	}

	public void setOnDuty(Boolean onDuty) {
		this.onDuty = onDuty;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getTasks() {
		return tasks;
	}

	public void setTasks(List<String> tasks) {
		this.tasks = tasks;
	}

	public List<String> getTeams() {
		return teams;
	}

	public void setTeams(List<String> teams) {
		this.teams = teams;
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

	public Long getTimeLastSeen() {
		return timeLastSeen;
	}

	public void setTimeLastSeen(Long timeLastSeen) {
		this.timeLastSeen = timeLastSeen;
	}

	public WorkerUserData getUserData() {
		return userData;
	}

	public void setUserData(WorkerUserData userData) {
		this.userData = userData;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public WorkerVehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(WorkerVehicle vehicle) {
		this.vehicle = vehicle;
	}
}
