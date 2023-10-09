package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Organization;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class OrganizationApi extends ApiBase {

	public OrganizationApi(OkHttpClient client) {
		super(client, "/organizations");
	}

	public Organization getDetails() throws Exception {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		if (!response.isSuccessful()) {
			throw new ApiException(response);
		}
		return JsonUtils.fromJson(response.body().string(), Organization.class);
	}

	public Organization getDelegateeDetails(String id) throws Exception {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		if (!response.isSuccessful()) {
			throw new ApiException(response);
		}
		return JsonUtils.fromJson(response.body().string(), Organization.class);
	}
}
