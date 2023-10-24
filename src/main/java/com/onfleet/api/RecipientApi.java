package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Metadata;
import com.onfleet.models.recipient.Recipient;
import com.onfleet.models.recipient.RecipientCreateParams;
import com.onfleet.models.recipient.RecipientUpdateParams;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;


public class RecipientApi extends BaseApi {

	public RecipientApi(OkHttpClient client) {
		super(client, "/recipients");
	}

	/**
	 * Retrieve details about a specific recipient by their ID.
	 * <a href="https://docs.onfleet.com/reference/get-single-recipient">Api Docs</a>
	 * @param recipientId The ID of the recipient to retrieve.
	 * @return A Recipient object representing the details of the retrieved recipient.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Recipient getSingleRecipient(String recipientId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, recipientId);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Recipient.class);
	}

	/**
	 * Find a recipient by their name.
	 * <a href="https://docs.onfleet.com/reference/find-recipient">Api Docs</a>
	 * @param name The name of the recipient to search for.
	 * @return A Recipient object representing the details of the found recipient.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Recipient findRecipientByName(String name) throws ApiException {
		String url = String.format("%s/name/%s", baseUrl, name);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Recipient.class);
	}

	/**
	 * Find a recipient by their phone number.
	 * <a href="https://docs.onfleet.com/reference/find-recipient">Api Docs</a>
	 * @param phone The phone number of the recipient to search for.
	 * @return A Recipient object representing the details of the found recipient.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Recipient findRecipientByPhone(String phone) throws ApiException {
		String url = String.format("%s/phone/%s", baseUrl, phone);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Recipient.class);
	}

	/**
	 * Create a new recipient based on the provided RecipientCreateParams.
	 * <a href="https://docs.onfleet.com/reference/create-recipient">Api Docs</a>
	 * @param createParams A RecipientCreateParams object containing the parameters for creating the recipient.
	 * @return A Recipient object representing the newly created recipient.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Recipient createRecipient(RecipientCreateParams createParams) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(createParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Recipient.class);
	}

	/**
	 * Update an existing recipient based on the provided parameters.
	 * <a href="https://docs.onfleet.com/reference/update-recipient">Api Docs</a>
	 * @param recipientId The ID of the recipient to update.
	 * @param updateParams A RecipientUpdateParams object containing the parameters for updating the recipient.
	 * @return A Recipient object representing the updated recipient.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Recipient updateRecipient(String recipientId, RecipientUpdateParams updateParams) throws ApiException {
		String url = String.format("%s/%s", baseUrl, recipientId);
		String jsonPayload = GsonSingleton.getInstance().toJson(updateParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Recipient.class);
	}

	/**
	 * Query recipients based on associated metadata. Metadata allows you to annotate recipients with personalized data.
	 * This method enables you to filter recipients based on specific metadata criteria.
	 * <a href="https://docs.onfleet.com/reference/metadata">Api Docs</a>
	 * @param metadata A list of Metadata objects containing personalized data for filtering recipients.
	 * @return A list of Recipient objects that match the specified metadata query criteria.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public List<Recipient> queryWithMetadata(List<Metadata> metadata) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, new TypeToken<List<Recipient>>() {
		}.getType());
	}
}
