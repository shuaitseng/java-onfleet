package com.onfleet.models.task;

public class TaskBarcode {
	private String data;
	private Boolean blockCompletion;

	public TaskBarcode(String data, Boolean blockCompletion) {
		this.data = data;
		this.blockCompletion = blockCompletion;
	}

	public Boolean getBlockCompletion() {
		return blockCompletion;
	}

	public String getData() {
		return data;
	}
}
