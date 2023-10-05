package com.onfleet.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String toJson(Object object) throws Exception {
		return objectMapper.writeValueAsString(object);
	}

	public static <T> T fromJson(String json, Class<T> valueType) throws Exception {
		return objectMapper.readValue(json, valueType);
	}
}
