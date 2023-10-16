package com.onfleet.models.task;

import java.util.List;

public class TaskBarcodeContainer {
	List<TaskCapturedBarcode> captured;
	List<TaskBarcode> required;

	public List<TaskCapturedBarcode> getCaptured() {
		return captured;
	}

	public void setCaptured(List<TaskCapturedBarcode> captured) {
		this.captured = captured;
	}

	public List<TaskBarcode> getRequired() {
		return required;
	}

	public void setRequired(List<TaskBarcode> required) {
		this.required = required;
	}
}
