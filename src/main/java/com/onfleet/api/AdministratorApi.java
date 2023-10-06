package com.onfleet.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Administrator;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.JsonUtils;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.ArrayList;

public class AdministratorApi extends ApiBase {
	public AdministratorApi(OkHttpClient client) {
		super(client, "/admins");
	}

	public Administrator createAdministrator(Administrator admin) throws Exception {
		String jsonPayload = JsonUtils.toJson(admin);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		if (!response.isSuccessful()) {
			throw new ApiException(response);
		}
		return JsonUtils.fromJson(response.body().string(), Administrator.class);
	}

	public ArrayList<Administrator> listAdministrators() throws Exception {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		if (!response.isSuccessful()) {
			throw new ApiException(response);
		}
		return JsonUtils.fromJson(response.body().string(), new TypeReference<ArrayList<Administrator>>() {});
	}

	public Administrator updateAdministrator(String adminId, Administrator admin) throws Exception {
		String url = String.format("%s/%s", baseUrl, adminId);
		String jsonPayload = JsonUtils.toJson(admin);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		if (!response.isSuccessful()) {
			throw new ApiException(response);
		}
		return JsonUtils.fromJson(response.body().string(), Administrator.class);
	}

	public void deleteAdministrator(String adminId) throws Exception {
		String url = String.format("%s/%s", baseUrl, adminId);
		sendRequest(HttpMethodType.DELETE, url);
	}
}
