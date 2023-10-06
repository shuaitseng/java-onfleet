package com.onfleet.exceptions;

public class JsonDeserializationException extends RuntimeException {
	public JsonDeserializationException(String message, Throwable t) {
		super(message, t);
	}
}
