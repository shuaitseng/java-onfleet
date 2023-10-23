package com.onfleet.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onfleet.models.administrator.AdministratorType;
import com.onfleet.models.task.TaskState;

public class GsonSingleton {
	private static final Gson gson = new GsonBuilder()
			.registerTypeAdapter(AdministratorType.class, new AdminTypeAdapter())
			.registerTypeAdapter(TaskState.class, new TaskStateDeserializer())
			.create();

	private GsonSingleton() {
	}

	public static Gson getInstance() {
		return gson;
	}

}
