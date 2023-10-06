package com.onfleet.api;

import com.onfleet.models.Hub;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.JsonUtils;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HubApi extends ApiBase {

	public HubApi(OkHttpClient client) {
		super(client, "/hubs");
	}

	public void createHub(Hub hub) throws Exception {
		String jsonPayload = JsonUtils.toJson(hub);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		System.out.println(response.body().string());
	}

	public void updateHub(String hubId, Hub hub) throws Exception {
		String url = String.format("%s/%s", baseUrl, hubId);
		String jsonPayload = JsonUtils.toJson(hub);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		System.out.println(response.body().string());
	}

	public void listHubs() throws Exception {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		System.out.println(response.body().string());
	}
}
