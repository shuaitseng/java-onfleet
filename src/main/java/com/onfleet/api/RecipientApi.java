package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Recipient;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;


public class RecipientApi extends BaseApi {

	public RecipientApi(OkHttpClient client) {
		super(client, "/recipients");
	}

	public Recipient createRecipient(Recipient recipient) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(recipient);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Recipient.class);
	}

	public Recipient updateRecipient(Recipient recipient) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(recipient);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, baseUrl);
		return handleResponse(response, Recipient.class);
	}

	public Recipient findRecipientByName(String name) throws ApiException {
		String url = String.format("%s/name/%s", baseUrl, name);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Recipient.class);
	}

	public Recipient findRecipientByPhone(String phone) throws ApiException {
		String url = String.format("%s/phone/%s", baseUrl, phone);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Recipient.class);
	}

	public Recipient getSingleRecipient(String recipientId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, recipientId);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Recipient.class);
	}
}
