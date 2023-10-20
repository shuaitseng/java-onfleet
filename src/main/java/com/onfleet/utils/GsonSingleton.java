package com.onfleet.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.onfleet.models.administrator.AdministratorType;

public class GsonSingleton {
	private static final Gson gson = new GsonBuilder()
			.registerTypeAdapter(AdministratorType.class, new AdminTypeAdapter())
			.create();

	private GsonSingleton() {}

	public static Gson getInstance() {
		return gson;
	}

}
