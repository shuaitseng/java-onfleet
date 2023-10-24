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

	/**
	 * Creates a new administrator based on the provided parameters.
	 * <a href="https://docs.onfleet.com/reference/create-administrator">Api Docs</a>
	 * @param createParams An AdminCreateParams object containing the parameters for creating the administrator.
	 * @return An Administrator object representing the newly created administrator.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Administrator createAdministrator(AdminCreateParams createParams) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(createParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, Administrator.class);
	}

	/**
	 * Retrieves a list of administrators
	 * <a href="https://docs.onfleet.com/reference/list-administrators">Api Docs</a>
	 * @return A list of Administrator objects representing the administrators in the system.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public List<Administrator> listAdministrators() throws ApiException {
		Response response = sendRequest(HttpMethodType.GET, baseUrl);
		return handleResponse(response, new TypeToken<List<Administrator>>() {
		}.getType());
	}

	/**
	 * Query administrators based on associated metadata. Metadata allows you to annotate administrators with personalized data.
	 * This method enables you to filter administrators based on specific metadata criteria.
	 *
	 * @param metadata A list of Metadata objects containing personalized data for filtering administrators.
	 * @return A list of Administrator objects that match the specified metadata query criteria.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public List<Administrator> queryByMetadata(List<Metadata> metadata) throws ApiException {
		String jsonPayload = GsonSingleton.getInstance().toJson(metadata);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.POST, body, baseUrl);
		return handleResponse(response, new TypeToken<List<Administrator>>() {
		}.getType());
	}

	/**
	 * Updates an existing administrator based on the provided parameters. This method allows you to modify the details
	 * of an existing administrator.
	 * <a href="https://docs.onfleet.com/reference/update-administrator">Api Docs</a>
	 * @param adminId The ID of the administrator to update.
	 * @param updateParams An AdminUpdateParams object containing the parameters for updating the administrator.
	 * @return An Administrator object representing the updated administrator.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public Administrator updateAdministrator(String adminId, AdminUpdateParams updateParams) throws ApiException {
		String url = String.format("%s/%s", baseUrl, adminId);
		String jsonPayload = GsonSingleton.getInstance().toJson(updateParams);
		RequestBody body = RequestBody.create(jsonPayload, MediaTypes.JSON);
		Response response = sendRequest(HttpMethodType.PUT, body, url);
		return handleResponse(response, Administrator.class);
	}

	/**
	 * Deletes an administrator based on the provided administrator ID
	 * <a href="https://docs.onfleet.com/reference/delete-administrator">Api Docs</a>
	 * @param adminId The ID of the administrator to delete.
	 * @throws ApiException If an error occurs during the API request or response handling.
	 */
	public void deleteAdministrator(String adminId) throws ApiException {
		String url = String.format("%s/%s", baseUrl, adminId);
		sendRequest(HttpMethodType.DELETE, url);
	}
}
