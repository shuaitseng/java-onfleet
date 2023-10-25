package com.onfleet.models.webhook;

public class Webhook {
	private String id;
	private Integer count;
	private String url;
	private Integer trigger;
	private Boolean isEnabled;
	private String name;
	private Double threshold;

	public String getId() {
		return id;
	}

	public Integer getCount() {
		return count;
	}

	public String getUrl() {
		return url;
	}

	public Integer getTrigger() {
		return trigger;
	}

	public Boolean getEnabled() {
		return isEnabled;
	}

	public String getName() {
		return name;
	}

	public Double getThreshold() {
		return threshold;
	}
}
