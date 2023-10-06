package com.onfleet.api;

import com.onfleet.OnFleet;
import com.onfleet.utils.HttpMethodType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiBase {
	protected final String baseUrl;
	protected final OkHttpClient client;

	public ApiBase(OkHttpClient client, String endpoint) {
		this.client = client;
		this.baseUrl = OnFleet.URL + endpoint;
	}

	protected Response sendRequest(HttpMethodType method, RequestBody body, String url) throws Exception {
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
		return client.newCall(request).execute();
	}

	protected Response sendRequest(HttpMethodType method, String url) throws Exception {
		return sendRequest(method, null, url);
	}
}
