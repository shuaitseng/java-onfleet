package com.onfleet.models;

public class WebhookCreateParams {
	private String name;
	private String url;
	private int trigger;
	private Integer threshold;

	public WebhookCreateParams() {
	}

	public WebhookCreateParams(String name, String url, int trigger, Integer threshold) {
		this.name = name;
		this.url = url;
		this.trigger = trigger;
		this.threshold = threshold;
	}

	public WebhookCreateParams(String name, String url, int trigger) {
		this(name, url, trigger, null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTrigger() {
		return trigger;
	}

	public void setTrigger(int trigger) {
		this.trigger = trigger;
	}

	public Integer getThreshold() {
		return threshold;
	}

	public void setThreshold(Integer threshold) {
		this.threshold = threshold;
	}
}
