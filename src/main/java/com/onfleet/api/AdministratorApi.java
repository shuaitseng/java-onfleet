package com.onfleet.api;

import com.google.gson.reflect.TypeToken;
import com.onfleet.exceptions.ApiException;
import com.onfleet.models.administrator.AdminCreateParams;
import com.onfleet.models.administrator.AdminUpdateParams;
import com.onfleet.models.administrator.Administrator;
import com.onfleet.models.Metadata;
import com.onfleet.utils.GsonSingleton;
import com.onfleet.utils.HttpMethodType;
import com.onfleet.utils.MediaTypes;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.List;

public class AdministratorApi extends BaseApi {

	public AdministratorApi(OkHttpClient client) {
		super(client, "/admins");
	}

	public Administrator createAdministrator(AdminCreateParams createParams) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(createParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Administrator.class);
	}

	public List<Administrator> listAdministrators() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, new TypeToken<List<Administrator>>() {
		}.getType());
	}

	public List<Administrator> listAdministratorsWithMetadataQuery(List<Metadata> metadata) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, new TypeToken<List<Administrator>>() {
		}.getType());
	}

	public Administrator updateAdministrator(String adminId, AdminUpdateParams updateParams) throws ApiException {
		String url = String.format("%s/%s", baseUrl, adminId);
		String jsonPayload = GsonSingleton.getInstance().toJson(updateParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Administrator.class);
	}

	public void deleteAdministrator(String adminId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, adminId);
		sendRequest(HttpMethodType.DELETE, url);
	}
}
