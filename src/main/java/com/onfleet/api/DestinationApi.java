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

	/**
	 * Retrieve information about a specific destination by its ID.
	 * <a href="https://docs.onfleet.com/reference/get-single-destination">Api Docs</a>
	 * @param id The ID of the destination to retrieve.
	 * @return A Destination object representing the retrieved destination's details.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Destination getDestination(String id) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Destination.class);
	}

	/**
	 * Create a new destination based on the provided DestinationCreateParams
	 * <a href="https://docs.onfleet.com/reference/create-destination">Api Docs</a>
	 * @param destination A DestinationCreateParams object containing the parameters for creating the destination.
	 * @return A Destination object representing the newly created destination.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Destination createDestination(DestinationCreateParams destination) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(destination);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Destination.class);
	}

	/**
	 * Query destinations based on associated metadata. Metadata allows you to annotate destinations with personalized data.
	 * This method enables you to filter destinations based on specific metadata criteria.
	 * <a href="https://docs.onfleet.com/reference/metadata">Api Docs</a>
	 * @param metadata A list of Metadata objects containing personalized data for filtering destinations.
	 * @return A list of Metadata objects representing destinations that match the specified metadata query criteria.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public List<Metadata> queryByMetadata(List<Metadata> metadata) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, new TypeToken<List<Administrator>>() {
		}.getType());
	}
}
