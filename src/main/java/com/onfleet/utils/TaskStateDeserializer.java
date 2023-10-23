package com.onfleet.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.onfleet.models.task.TaskState;

import java.lang.reflect.Type;

public class TaskStateDeserializer implements JsonDeserializer<TaskState> {
	@Override
	public TaskState deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
		int value = jsonElement.getAsInt();
		switch (value) {
			case 0:
				return TaskState.UNASSIGNED;
			case 1:
				return TaskState.ASSIGNED;
			case 2:
				return TaskState.ACTIVE;
			case 3:
				return TaskState.COMPLETED;
			default:
				throw new JsonParseException("Invalid value for TaskState: " + value);
		}
	}
}
