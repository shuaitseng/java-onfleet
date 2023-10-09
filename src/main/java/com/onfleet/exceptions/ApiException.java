package com.onfleet.exceptions;

import com.onfleet.models.ErrorResponse;
import com.onfleet.utils.GsonSingleton;
import okhttp3.Response;

import java.io.IOException;

public class ApiException extends Exception {

	private int statusCode; // HTTP status code
	private ErrorResponse errorResponse; // Error response from the API

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(Response response) {
		super(response.message());
		this.statusCode = response.code();
		try {
			if (response.body() != null) {
				this.errorResponse = GsonSingleton.getInstance().fromJson(response.body().string(), ErrorResponse.class);
			}
		} catch (IOException e) {
			initCause(e);
		}
	}

	public int getStatusCode() {
		return statusCode;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}
}
