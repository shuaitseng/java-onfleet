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

	public void setBlockCompletion(Boolean blockCompletion) {
		this.blockCompletion = blockCompletion;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
