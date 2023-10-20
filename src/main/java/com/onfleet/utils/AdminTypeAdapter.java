package com.onfleet.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.onfleet.models.administrator.AdministratorType;

import java.io.IOException;

public class AdminTypeAdapter extends TypeAdapter<AdministratorType> {

	@Override
	public void write(JsonWriter jsonWriter, AdministratorType type) throws IOException {
		if (type == null) {
			jsonWriter.nullValue();
			return;
		}
		jsonWriter.value(type.getStringValue().toLowerCase());
	}

	@Override
	public AdministratorType read(JsonReader jsonReader) throws IOException {
		if (jsonReader.peek() == JsonToken.NULL) {
			jsonReader.nextNull();
			return null;
		}
		String lowerCase = jsonReader.nextString().toLowerCase();
		for (AdministratorType type : AdministratorType.values()) {
			if (type.getStringValue().equals(lowerCase)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid Type: " + lowerCase);
	}
}
