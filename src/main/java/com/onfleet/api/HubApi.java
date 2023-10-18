package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.hub.Hub;
import com.onfleet.models.hub.HubParams;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

public class HubApi extends BaseApi {

	public HubApi(OkHttpClient client) {
		super(client, "/hubs");
	}

	public Hub createHub(HubParams hub) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(hub);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Hub.class);
	}

	public Hub updateHub(String hubId, HubParams hub) throws ApiException {
		String url = String.format("%s/%s", baseUrl, hubId);
		String jsonPayload = GsonSingleton.getInstance().toJson(hub);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Hub.class);
	}

	public List<Hub> listHubs() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, new TypeToken<ArrayList<Hub>>(){}.getType());
	}
}
