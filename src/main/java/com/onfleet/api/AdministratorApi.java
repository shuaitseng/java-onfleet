package com.onfleet.api;

import com.onfleet.models.Administrator;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.JsonUtils;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AdministratorApi extends ApiBase {
	public AdministratorApi(OkHttpClient client) {
		super(client, "/admins");
	}

	public void createAdministrator(Administrator admin) throws Exception {
		String jsonPayload = JsonUtils.toJson(admin);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		System.out.println(response.body().string());
	}

	public void listAdministrators() throws Exception {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		System.out.println(response.body().string());
	}

	public void updateAdministrator(String adminId, Administrator admin) throws Exception {
		String url = String.format("%s/%s", baseUrl, adminId);
		String jsonPayload = JsonUtils.toJson(admin);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		System.out.println(response.body().string());
	}

	public void deleteAdministrator(String adminId) throws Exception {
		String url = String.format("%s/%s", baseUrl, adminId);
		Response response = sendRequest(HttpMethodType.DELETE, url);
		System.out.println(response.body().string());
	}
}
