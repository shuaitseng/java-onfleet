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

	/**
	 * Create a new hub based on the provided HubParams
	 * <a href="https://docs.onfleet.com/reference/create-hub">Api Docs</a>
	 * @param hub A HubParams object containing the parameters for creating the hub.
	 * @return A Hub object representing the newly created hub.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Hub createHub(HubParams hub) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(hub);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Hub.class);
	}

	/**
	 * Update an existing hub based on the provided parameters.
	 * <a href="https://docs.onfleet.com/reference/update-hub">Api Docs</a>
	 * @param hubId The ID of the hub to update.
	 * @param hub A HubParams object containing the parameters for updating the hub.
	 * @return A Hub object representing the updated hub.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Hub updateHub(String hubId, HubParams hub) throws ApiException {
		String url = String.format("%s/%s", baseUrl, hubId);
		String jsonPayload = GsonSingleton.getInstance().toJson(hub);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Hub.class);
	}

	/**
	 * Retrieve a list of hubs.
	 * <a href="https://docs.onfleet.com/reference/list-hubs">Api Docs</a>
	 * @return A list of Hub objects representing the hubs in the system.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public List<Hub> listHubs() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, new TypeToken<ArrayList<Hub>>(){}.getType());
	}
}
