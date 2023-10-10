package com.onfleet.api;

import com.onfleet.exceptions.ApiException;
import com.onfleet.models.Organization;
import com.onfleet.utils.HttpMethodType;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class OrganizationApi extends BaseApi {

	public OrganizationApi(OkHttpClient client) {
		super(client, "/organizations");
	}

	public Organization getDetails() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, Organization.class);
	}

	public Organization getDelegateeDetails(String id) throws ApiException {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		return handleResponse(response, Organization.class);
	}
}
