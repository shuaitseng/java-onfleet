package com.onfleet.api;

import com.onfleet.OnFleet;
import com.onfleet.models.Recipient;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.JsonUtils;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RecipientApi extends ApiBase {
	private final String URL = OnFleet.URL + "/recipients";

	public RecipientApi(OkHttpClient client) {
		super(client, "/recipients");
	}

	public void createRecipient(Recipient recipient) throws Exception {
		String jsonPayload = JsonUtils.toJson(recipient);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		System.out.println(response.body().string());
	}

	public void updateRecipient() {

	}

	public void findRecipientByName(String name) throws Exception {
		String url = String.format("%s/name/%s", URL, name);
		Response response = sendRequest(HttpMethodType.GET, url);
		System.out.println(response.body().string());
	}

	public void findRecipientByPhone(String phone) throws Exception {
		String url = String.format("%s/phone/%s", URL, phone);
		Response response = sendRequest(HttpMethodType.GET, url);
		System.out.println(response.body().string());
	}

	public void getSingleRecipient(String recipientId) throws Exception {
		String url = String.format("%s/%s", URL, recipientId);
		Response response = sendRequest(HttpMethodType.GET, url);
		System.out.println(response.body().string());
	}
}
