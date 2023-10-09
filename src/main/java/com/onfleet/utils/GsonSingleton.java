package com.onfleet.utils;

import com.google.gson.Gson;

public class GsonSingleton {
	private static final Gson gson = new Gson();

	private GsonSingleton() {}

	public static Gson getInstance() {
		return gson;
	}

}
