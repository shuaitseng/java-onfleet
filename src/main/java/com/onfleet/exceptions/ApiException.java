package com.onfleet.exceptions;

import com.onfleet.models.ErrorResponse;
import com.onfleet.utils.JsonUtils;
import okhttp3.Response;

import java.io.IOException;

public class ApiException extends Exception {

	private int statusCode; // HTTP status code
	private ErrorResponse errorResponse; // Error response from the API

	public ApiException(Response response) throws IOException {
		super(response.message());
		this.statusCode = response.code();
		if (response.body() != null) {
			this.errorResponse = JsonUtils.fromJson(response.body().string(), ErrorResponse.class);
		}
	}

	public int getStatusCode() {
		return statusCode;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
}
