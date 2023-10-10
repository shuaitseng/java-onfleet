package com.onfleet.api;

import com.onfleet.OnFleet;
import com.onfleet.exceptions.ApiException;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.lang.reflect.Type;

public class BaseApi {
	protected final String baseUrl;
	protected final OkHttpClient client;

	public BaseApi(OkHttpClient client, String endpoint) {
		this.client = client;
		this.baseUrl = OnFleet.URL + endpoint;
	}

	protected Response sendRequest(HttpMethodType method, RequestBody body, String url) throws ApiException {
		try {
			Request.Builder requestBuilder = new Request.Builder().url(url);
			switch (method) {
				case GET:
					requestBuilder.get();
					break;
				case POST:
					requestBuilder.post(body);
					break;
				case PUT:
					requestBuilder.put(body);
					break;
				case DELETE:
					requestBuilder.delete();
					break;
				default:
					throw new IllegalArgumentException("Invalid HTTP method: " + method);
			}
			Request request = requestBuilder.build();
			Response response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
				throw new ApiException(response);
			}
			return response;
		} catch (IOException e) {
			throw new ApiException("Failed to send HTTP request: " + e.getMessage(), e);
		}
	}

	protected Response sendRequest(HttpMethodType method, String url) throws ApiException {
		return sendRequest(method, null, url);
	}

	protected <T> T handleResponse(Response response, Type type) throws ApiException {
		if (!response.isSuccessful()) {
			throw new ApiException(response);
		}
		ResponseBody responseBody = response.body();
		if (responseBody != null) {
			try {
				String json = responseBody.string();
				return GsonSingleton.getInstance().fromJson(json, type);
			} catch (IOException e) {
				throw new ApiException("Failed to read response body: " + e.getMessage(), e);
			} finally {
				responseBody.close();
			}
		}
		return null;
	}

}
