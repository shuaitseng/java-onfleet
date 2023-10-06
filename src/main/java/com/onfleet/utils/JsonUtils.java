package com.onfleet.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onfleet.exceptions.JsonDeserializationException;

public class JsonUtils {
	private JsonUtils() {}

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String toJson(Object object) throws Exception {
		return objectMapper.writeValueAsString(object);
	}

	public static <T> T fromJson(String json, Class<T> valueType) {
		return fromJson(json, () -> objectMapper.readValue(json, valueType));
	}

	public static <T> T fromJson(String json, TypeReference<T> valueType) {
		return fromJson(json, () -> objectMapper.readValue(json, valueType));
	}

	private static <T> T fromJson(String json, ThrowingSupplier<T, JsonProcessingException> supplier) {
		try {
			return supplier.get();
		} catch (JsonProcessingException e) {
			throw new JsonDeserializationException("Error deserializing JSON: " + json, e);
		}
	}
}
