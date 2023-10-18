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


public class RecipientApi extends BaseApi {

	public RecipientApi(OkHttpClient client) {
		super(client, "/recipients");
	}

	public Recipient getSingleRecipient(String recipientId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, recipientId);
		Response response = sendRequest(HttpMethodType.GET, url);
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

	public Recipient createRecipient(RecipientCreateParams createParams) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(createParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Recipient.class);
	}

	public Recipient updateRecipient(String recipientId, RecipientUpdateParams updateParams) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(updateParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, baseUrl);
		return handleResponse(response, Recipient.class);
	}
}
