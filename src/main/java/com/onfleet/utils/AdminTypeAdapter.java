package com.onfleet.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.onfleet.models.Administrator;

import java.io.IOException;

public class AdminTypeAdapter extends TypeAdapter<Administrator.Type> {

	@Override
	public void write(JsonWriter jsonWriter, Administrator.Type type) throws IOException {
		if (type == null) {
			jsonWriter.nullValue();
			return;
		}
		jsonWriter.value(type.getStringValue().toLowerCase());
	}

	@Override
	public Administrator.Type read(JsonReader jsonReader) throws IOException {
		if (jsonReader.peek() == JsonToken.NULL) {
			jsonReader.nextNull();
			return null;
		}
		String lowerCase = jsonReader.nextString().toLowerCase();
		for (Administrator.Type type : Administrator.Type.values()) {
			if (type.getStringValue().equals(lowerCase)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid Type: " + lowerCase);
	}
}
