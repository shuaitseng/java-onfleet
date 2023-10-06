package com.onfleet.api;

import com.onfleet.OnFleet;
import com.onfleet.utils.HttpMethodType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrganizationApi extends ApiBase {

	public OrganizationApi(OkHttpClient client) {
		super(client, "/organizations");
	}

	public void getDetails() throws Exception {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		System.out.println(response.body().string());
	}

	public void getDelegateeDetails(String id) throws Exception {
		String url = String.format("%s/%s", baseUrl, id);
		Response response = sendRequest(HttpMethodType.GET, url);
		System.out.println(response.body().string());
	}
}
