package com.onfleet.models.worker;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Workers {
	@SerializedName("workers")
	private List<Worker> workerList;

	public List<Worker> getWorkers() {
		return workerList;
	}

}
