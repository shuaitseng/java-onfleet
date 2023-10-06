package com.onfleet.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.onfleet.models.Administrator.Type;

import java.io.IOException;

public class TypeDeserializer extends JsonDeserializer<Type> {
	@Override
	public Type deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		String type = jsonParser.getValueAsString().toLowerCase();
		return Type.valueOf(type.toUpperCase());
	}
}
