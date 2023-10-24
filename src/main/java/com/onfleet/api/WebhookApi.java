package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.webhook.Webhook;
import com.onfleet.models.webhook.WebhookCreateParams;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

public class WebhookApi extends BaseApi {

	public WebhookApi(OkHttpClient client) {
		super(client, "/webhooks");
	}

	/**
	 * Create a new webhook based on the provided WebhookCreateParams.
	 * <a href="https://docs.onfleet.com/reference/create-webhook">Api Docs</a>
	 * @param params A WebhookCreateParams object containing the parameters for creating the webhook.
	 * @return A Webhook object representing the newly created webhook.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Webhook create(WebhookCreateParams params) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(params);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Webhook.class);
	}

	/**
	 * Retrieve a list of webhooks.
	 * <a href="https://docs.onfleet.com/reference/list-webhooks">Api Docs</a>
	 * @return A list of Webhook objects representing the webhooks in your application.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public List<Webhook> list() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, new TypeToken<List<Webhook>>() {
		}.getType());
	}

	/**
	 * Delete a webhook based on its ID.
	 * <a href="https://docs.onfleet.com/reference/delete-webhook">Api Docs</a>
	 * @param webhookId The ID of the webhook to delete.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public void delete(String webhookId) throws ApiException {
		sendRequest(HttpMethodType.DELETE, String.format("%s/%s", baseUrl, webhookId));
	}
}
