package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Webhook;
import com.onfleet.models.WebhookCreateParams;
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

	public Webhook create(WebhookCreateParams params) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(params);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Webhook.class);
	}

	public List<Webhook> list() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, new TypeToken<List<Webhook>>() {
		}.getType());
	}

	public void delete(String webhookId) throws ApiException {
		sendRequest(HttpMethodType.DELETE, String.format("%s/%s", baseUrl, webhookId));
	}
}
