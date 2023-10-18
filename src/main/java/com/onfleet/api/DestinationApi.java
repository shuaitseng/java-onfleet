package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Metadata;
import com.onfleet.models.administrator.Administrator;
import com.onfleet.models.destination.Destination;
import com.onfleet.models.destination.DestinationCreateParams;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

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

	public List<Metadata> queryByMetadata(List<Metadata> metadata) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, new TypeToken<List<Administrator>>() {
		}.getType());
	}
}
