package com.onfleet.utils;

import okhttp3.MediaType;

public class MediaTypes {
	private MediaTypes() {
	}

	public static final MediaType JSON = MediaType.parse("application/json");
	public static final MediaType XML = MediaType.parse("application/xml");
	public static final MediaType PLAIN_TEXT = MediaType.parse("text/plain");
}
