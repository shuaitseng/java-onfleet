package com.onfleet.models.worker;

public enum WorkerFilterFields {
	ID("id"),
	TIME_CREATED("timeCreated"),
	TIME_LAST_MODIFIED("timeLastModified"),
	ORGANIZATION("organization"),
	NAME("name"),
	DISPLAY_NAME("displayName"),
	PHONE("phone"),
	ACTIVE_TASK("activeTask"),
	TASKS("tasks"),
	ON_DUTY("onDuty"),
	TIME_LASTSEEN("timeLastSeen"),
	CAPACITY("capacity"),
	ADDITIONAL_CAPACITIES("additionalCapacities"),
	USERDATA("userData"),
	ACCOUNT_STATUS("accountStatus"),
	METADATA("metadata"),
	TIMEZONE("timezone"),
	TEAMS("teams"),
	IMAGE_URL("imageUrl"),
	LOCATION("location"),
	DELAY_TIME("delayTime"),
	VEHICLE("vehicle");

	private final String value;

	WorkerFilterFields(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
