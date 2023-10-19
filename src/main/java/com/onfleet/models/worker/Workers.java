package com.onfleet.models.worker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onfleet.models.worker.Worker;

import java.util.List;

public class Workers {
	@JsonProperty("workers")
	private List<Worker> workerList;

	public List<Worker> getWorkers() {
		return workerList;
	}

	public void setWorkers(List<Worker> workers) {
		this.workerList = workers;
	}
}
