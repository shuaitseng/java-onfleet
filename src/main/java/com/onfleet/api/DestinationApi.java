package com.onfleet.api;

import com.onfleet.models.Destination;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.JsonUtils;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

//TODO: improve error handling
public class DestinationApi extends ApiBase {

	public DestinationApi(OkHttpClient client) {
		super(client, "/destinations");
	}

	public void createDestination(Destination destination) throws Exception {
		String jsonPayload = JsonUtils.toJson(destination);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		System.out.println(response.body().string());
	}

	public void getDestination(String id) throws Exception {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		System.out.println(response.body().string());
	}
}
