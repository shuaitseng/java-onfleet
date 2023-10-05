package com.onfleet.destinations;

import com.onfleet.OnFleet;
import com.onfleet.models.Destination;
import com.onfleet.utils.JsonUtils;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DestinationApi {
	private final String URL = OnFleet.URL + "/destinations";
	private final OkHttpClient client;

	public DestinationApi(OkHttpClient client) {
		this.client = client;
	}

	public void createDestination(Destination destination) throws Exception {
		String jsonPayload = JsonUtils.toJson(destination);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Request request = new Request.Builder()
				.url(URL)
				.post(body)
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());

	}

	public void getDestination(String id) throws Exception {
		String url = String.format("%s/%s", URL, id);
		Request request = new Request.Builder()
				.url(url)
				.get()
				.build();
		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
	}
}
