package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Destination;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DestinationApi extends BaseApi {

	public DestinationApi(OkHttpClient client) {
		super(client, "/destinations");
	}

	public Destination getDestination(String id) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Destination.class);
	}

	public Destination createDestination(DestinationCreateParams destination) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(destination);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Destination.class);
	}

	public Destination getDestination(String id) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Destination.class);
	}
}
